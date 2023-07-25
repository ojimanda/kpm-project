package id.yozi.kpmservice.service;

import id.yozi.kpmservice.model.User;
import id.yozi.kpmservice.model.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface UserService {


    public ResponseTemplate<UserDTO> createUser(User user);

    public ResponseTemplate<UserDTO> deleteUser(String email);

    public ResponseTemplate<LoginResponse> loginUser(LoginRequest loginRequest);



}
