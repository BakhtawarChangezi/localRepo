package net.javaguides.springboot.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.Mapper.AutoUserMapper;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exception.EmailAlreadyException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto into User JPA ENtity

//        User user1 = UserMapper.getUser(userDto);
//        User user1 = modelMapper.map(userDto,User.class);

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());


        if(optionalUser.isPresent()) {
            throw new EmailAlreadyException("Email already in use");
        }

        User user1 = AutoUserMapper.MAPPER.maptoUser(userDto);
        User savedUser = userRepository.save(user1);

        //Convert User Jpa Entity to UserDto
//        UserDto savedUserDto = UserMapper.getUserDto(savedUser);
//        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        UserDto savedUserDto = AutoUserMapper.MAPPER.maptoUserDto(savedUser);


        return savedUserDto;

    }

    @Override
    public UserDto getUserById(Long id) {

        User optionalUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User","id",id)

        );

//        User  user=optionalUser.get();
        return AutoUserMapper.MAPPER.maptoUserDto(optionalUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List <User> user= userRepository.findAll();

   //    return user.stream().map((users)->modelMapper.map(users,UserDto.class)).collect(Collectors.toList());
       return user.stream().map((users)->AutoUserMapper.MAPPER.maptoUserDto(users)).collect(Collectors.toList());


    }

    @Override
    public UserDto updateUser(UserDto user) {
        User user1 = userRepository.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User","id",user.getId())

        );
        user1.setFirstname(user.getFirstname());
        user1.setLastname(user.getLastname());
        user1.setEmail(user.getEmail());
        User updatedUser = userRepository.save(user1);
        //return UserMapper.getUserDto(updatedUser);
        //return modelMapper.map(updatedUser, UserDto.class);
        return  AutoUserMapper.MAPPER.maptoUserDto(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        User user1 = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User","id",id)

        );
        userRepository.deleteById(id);

    }


}
