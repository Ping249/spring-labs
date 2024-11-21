package com.lt.spring.labs.services;

import com.lt.spring.labs.Repo.UserRepository;
import com.lt.spring.labs.dto.*;
import com.lt.spring.labs.entities.User;
import com.lt.spring.labs.exceptions.core.ForbiddenAccountActionException;
import com.lt.spring.labs.exceptions.core.ItemNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepo;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepo, ModelMapper mapper) {
        this.mapper = mapper;
        this.userRepo = userRepo;
    }

    @Override
    public GetUserProfileDTO addUser(AddUserDTO user) {
        User u = new User(0L, user.getFirstName(),
                user.getLastName(), null,  user.getEmailAddress(),
                user.getPhoneNumber(), user.getCountryOfResidence(),
                user.getGovernmentIdentifier(), 0L, user.getIdentifierType());
        u = userRepo.save(u);
        GetUserProfileDTO uDTO = this.mapper.map(u, GetUserProfileDTO.class);
        return uDTO;
    }

    @Override
    public GetUserProfileDTO getUser(Long id) {
        User u = userRepo.findById(id).get();
        GetUserProfileDTO uDTO = this.mapper.map(u, GetUserProfileDTO.class);
        return uDTO;
    }

    @Override
    public Iterable<GetUserProfileDTO> getUsers() {
        return StreamSupport.stream(userRepo.findAll().spliterator(), false)
                .map(u -> mapper.map(u, GetUserProfileDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetUserProfileDTO updateContactDetails(UpdateContactDetailsDTO request) {
        Optional<User> opUser = userRepo.findById(request.getId());
        if(opUser.isEmpty()) {
            throw new ItemNotFoundException("User not found");
        }
        User u = opUser.get();
        if(request.getEmailAddress()  != null  && !u.getEmailAddress().equalsIgnoreCase(request.getEmailAddress())) {
            u.setEmailAddress(request.getEmailAddress());
        }
        if(request.getPhoneNumber() != null && !u.getPhoneNumber().equalsIgnoreCase(request.getPhoneNumber())) {
            u.setPhoneNumber(request.getPhoneNumber());
        }
        userRepo.save(u);
        return mapper.map(u, GetUserProfileDTO.class);
    }

    @Override
    public boolean performTransfer(TransferFundsDTO request) {
        Optional<User> opUser = userRepo.findById(request.getUserId());
        if(opUser.isEmpty()) {
            throw new ItemNotFoundException("User not found");
        }
        if(request.getAmount() == 0) {
            throw new ForbiddenAccountActionException("Cannot make transfer with no value");
        }
        User user = opUser.get();
        if(request.getAmount() < 0) {
            if (user.getBalanceHeldOnAccount() + request.getAmount() < 0) {
                throw new ForbiddenAccountActionException("Cannot debit the given amount");
            }
        }
        user.setBalanceHeldOnAccount(user.getBalanceHeldOnAccount() + request.getAmount());
        userRepo.save(user);
        return true;
    }
    @Override
    public GetBalanceDTO getBalanceOnAccount(Long id) {
        Optional<User> opUser = userRepo.findById(id);
        if(opUser.isEmpty()) {
            throw new ItemNotFoundException("User not found");
        }
        User u = opUser.get();
        return new GetBalanceDTO(u.getId(), u.getBalanceHeldOnAccount());
    }
}
