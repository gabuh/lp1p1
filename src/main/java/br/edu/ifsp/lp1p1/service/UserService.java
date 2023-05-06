package br.edu.ifsp.lp1p1.service;

import br.edu.ifsp.lp1p1.dto.user.UserRequestDTO;
import br.edu.ifsp.lp1p1.dto.user.UserResponseDTO;
import br.edu.ifsp.lp1p1.exception.user.UserNotFoundException;
import br.edu.ifsp.lp1p1.mapper.user.UserMapper;
import br.edu.ifsp.lp1p1.mapper.user.UserResponseDTOMapper;
import br.edu.ifsp.lp1p1.model.User;
import br.edu.ifsp.lp1p1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id){
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<UserResponseDTO> findAll(){
        List<User> users = this.userRepository.findAll();
        List<UserResponseDTO> userResponseDTOs = users.stream()
                .map(UserResponseDTOMapper.INSTANCE::toUserResponseDTO).toList();
        return userResponseDTOs;
    }

    public UserResponseDTO findByCpf(String cpf){
        User user = this.userRepository.findByCpf(cpf);
        return UserResponseDTOMapper.INSTANCE.toUserResponseDTO(user);
    }

    public void deleteById(Long id){
        this.userRepository.deleteById(findById(id).getId());
    }

    public void save(UserRequestDTO userRequestDTO){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = UserMapper.INSTANCE.toUser(userRequestDTO);
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        this.userRepository.save(user);
    }

    public void save(User user){
        this.userRepository.save(user);
    }

    public User findByEmail(String email){
        return this.userRepository.findByEmail(email);
//        return UserResponseDTOMapper.INSTANCE.toUserResponseDTO(user);
    }
}
