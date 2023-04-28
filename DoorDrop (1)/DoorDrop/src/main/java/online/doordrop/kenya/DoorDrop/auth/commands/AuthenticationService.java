package online.doordrop.kenya.DoorDrop.auth.commands;

import com.google.firebase.auth.FirebaseAuthException;

import lombok.RequiredArgsConstructor;
import online.doordrop.kenya.DoorDrop.config.JWTService;
import online.doordrop.kenya.DoorDrop.auth.firebaseUser.FirebaseUserService;
import online.doordrop.kenya.DoorDrop.auth.user.Role;
import online.doordrop.kenya.DoorDrop.auth.user.User;
import online.doordrop.kenya.DoorDrop.auth.user.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;


    private final AuthenticationProvider authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) throws FirebaseAuthException {

        var user= User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);


        CompletableFuture<String> future = FirebaseUserService.signUpUser(request.getEmail(),request.getPassword(),request.getFirstname(),request.getLastname());

        var signInUid= future.join();

        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .email(request.getEmail())
                .loginUID(signInUid)
                .build();


    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws ExecutionException, FirebaseAuthException, InterruptedException {
         authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

         var user=repository.findByEmail(request.getEmail())
                 .orElseThrow();

        var loginUid=FirebaseUserService.logInUser(request.getEmail());

        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .email(request.getEmail())
                .loginUID(loginUid)
                .build();
    }
}
