package com.lt.spring.labs.services;

import com.lt.spring.labs.Repo.UserRepository;
import com.lt.spring.labs.dto.AddUserDTO;
import com.lt.spring.labs.dto.GetUserProfileDTO;
import com.lt.spring.labs.dto.UpdateContactDetailsDTO;
import com.lt.spring.labs.entities.User;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepo;
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public GetUserProfileDTO addUser(AddUserDTO user) {
        //return userRepo.save(user);
        User u = new User(0L, user.getFirstName(),
                user.getLastName(), null, user.getEmailAddress(),
                user.getPhoneNumber(), user.getCountryOfResidence(),
                user.getGovernmentIdentifier(), 0L, user.getIdentifierType());
        userRepo.save(u);
        return new GetUserProfileDTO(u.getId(), u.getFirstName(), u.getLastName(),
                u.getEmailAddress(), u.getPhoneNumber());
    }

    @Override
    public GetUserProfileDTO getUser(Long id) {
        User u = userRepo.findById(id).get();
        return new GetUserProfileDTO(u.getId(), u.getFirstName(), u.getLastName(),
                u.getEmailAddress(), u.getPhoneNumber());
    }

    @Override
    public Iterable<GetUserProfileDTO> getUsers() {
        //return userRepo.findAll();
        return StreamSupport.stream(userRepo.findAll().spliterator(), false)
                .map(u -> new GetUserProfileDTO(u.getId(), u.getFirstName(), u.getLastName(), u.getEmailAddress(), u.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public GetUserProfileDTO updateContactDetails(UpdateContactDetailsDTO request)
    {
        User u = userRepo.findById(request.getId()).get();
        if(!u.getEmailAddress().isBlank() && !u.getEmailAddress().equalsIgnoreCase(request.getEmailAddress())) {
            u.setEmailAddress(request.getEmailAddress());
        }
        if(!u.getPhoneNumber().isBlank() && !u.getPhoneNumber().equalsIgnoreCase(request.getPhoneNumber())) {
            u.setPhoneNumber(request.getPhoneNumber());
        }
        userRepo.save(u);
        return new GetUserProfileDTO(u.getId(), u.getFirstName(), u.getLastName(), u.getEmailAddress(), u.getPhoneNumber());
    }


}
