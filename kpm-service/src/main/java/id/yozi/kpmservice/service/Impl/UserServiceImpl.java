package id.yozi.kpmservice.service.Impl;

import id.yozi.kpmservice.Utils.UserUtil;
import id.yozi.kpmservice.config.BCrypt;
import id.yozi.kpmservice.model.User;
import id.yozi.kpmservice.model.dto.*;
import id.yozi.kpmservice.repository.UserRepository;
import id.yozi.kpmservice.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;

import java.util.UUID;

@Service
public class UserServiceImpl extends Exception implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public ResponseTemplate<UserDTO> createUser(User user) {
        ResponseTemplate<UserDTO> response = new ResponseTemplate<>();
            if(user.getEmail().equals("") || user.getPassword().equals("")) {
                response.setResponseCode(401);
                response.setResponseMessage("Please Input your email or password");
                response.setResponseData(new UserDTO());
            } else {
                UserUtil userUtil = new UserUtil();

                if (userUtil.regexEmail(user.getEmail()) || userUtil.regexPassword(user.getPassword())) {
                    User getUser = userRepository.findByEmail(user.getEmail());
                    if(getUser == null) {
                        response.setResponseCode(201);
                        response.setResponseMessage("OK");
                        ModelMapper mapper = new ModelMapper();
                        UserDTO userDTO = mapper.map(user, UserDTO.class);
                        response.setResponseData(userDTO);
                        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
                        userRepository.save(user);
                    } else {
                        response.setResponseCode(401);
                        response.setResponseMessage("Email already exist");
                        response.setResponseData(new UserDTO());
                    }
                } else {
                    response.setResponseCode(401);
                    response.setResponseMessage("Wrong your email or password");
                    response.setResponseData(new UserDTO());
                }
            }
        return response;
    }

    @Override
    public ResponseTemplate<UserDTO> deleteUser(String email) {
        ResponseTemplate<UserDTO> response = new ResponseTemplate<>();
        User user = userRepository.findByEmail(email);
        if(user != null) {
            userRepository.deleteByEmail(email);
            response.setResponseCode(200);
            response.setResponseMessage("Successfully Delete user "+ email);
            ModelMapper mapper = new ModelMapper();
            UserDTO userDTO = mapper.map(user, UserDTO.class);
            response.setResponseData(userDTO);
        } else {
            response.setResponseCode(401);
            response.setResponseMessage("Cannot found user with email "+ email);
            response.setResponseData(new UserDTO());
        }
        return response;
    }

    @Transactional
    @Override
    public ResponseTemplate<LoginResponse> loginUser(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail());
        ResponseTemplate<LoginResponse> response = new ResponseTemplate<>();

        UserUtil util = new UserUtil();
        if(user == null) {
            response.setResponseCode(401);
            response.setResponseMessage("Wrong email or password");
            response.setResponseData(new LoginResponse());
        } else {
            if (user.getToken() != null) {
                response.setResponseCode(401);
                response.setResponseMessage("User {} "+ user.getEmail()+ " has been logged in");
                response.setResponseData(new LoginResponse());
            } else {
                if(BCrypt.checkpw(loginRequest.getPassword(), user.getPassword())) {
                    String token = UUID.randomUUID().toString();
                    user.setToken(token);
                    user.setExpiredAt(util.setExpired10Day());
                    response.setResponseCode(200);
                    response.setResponseMessage("OK");
                    LoginResponse loginResponse = LoginResponse.builder().
                            email(user.getEmail()).
                            token(token).
                            build();
                    response.setResponseData(loginResponse);
                    userRepository.save(user);
                } else {
                    response.setResponseCode(401);
                    response.setResponseMessage("Wrong email or password");
                    response.setResponseData(new LoginResponse());
                }
            }


        }
        return response;
    }
}
