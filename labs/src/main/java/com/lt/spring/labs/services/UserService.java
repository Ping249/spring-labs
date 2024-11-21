package com.lt.spring.labs.services;

import com.lt.spring.labs.dto.*;
import com.lt.spring.labs.entities.User;

public interface UserService {
    GetUserProfileDTO getUser(Long id);
    Iterable<GetUserProfileDTO> getUsers();
    GetUserProfileDTO addUser(AddUserDTO user);
    GetUserProfileDTO updateContactDetails(UpdateContactDetailsDTO request);
    boolean performTransfer(TransferFundsDTO request);
    public GetBalanceDTO getBalanceOnAccount(Long id);
}
