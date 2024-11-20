package com.lt.spring.labs.services;

import com.lt.spring.labs.dto.AddUserDTO;
import com.lt.spring.labs.dto.GetUserProfileDTO;
import com.lt.spring.labs.dto.UpdateContactDetailsDTO;
import com.lt.spring.labs.entities.User;

public interface UserService {
    GetUserProfileDTO getUser(Long id);
    Iterable<GetUserProfileDTO> getUsers();
    GetUserProfileDTO addUser(AddUserDTO user);
    GetUserProfileDTO updateContactDetails(UpdateContactDetailsDTO request);
}
