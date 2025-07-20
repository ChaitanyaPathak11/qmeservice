package com.cp.qmeservice.repository;

import com.cp.qmeservice.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
class UserRepositoryTest
{
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Should return user when email exists")
    void testFindByEmail()
    {
        // Given
        User user = new User();
        user.setFirstName("Chaitanya");
        user.setEmail("chai@example1.com");
        user.setPassword("password123");
        userRepository.save(user);

        // When
        User found = userRepository.findByEmail("chai@example1.com");

        // Then
        assertThat(found).isNotNull();
        assertThat(found.getFirstName()).isEqualTo("Chaitanya");
    }

    @Test
    @DisplayName("Should return null when email does not exist")
    void testFindByEmail_NotFound()
    {
        // When
        User found = userRepository.findByEmail("nonexistent@example.com");

        // Then
        assertThat(found).isNull();
    }

    @Test
    @DisplayName("Should return true when email exists")
    void testExistsByEmailTrue()
    {
        // Given
        User user = new User();
        user.setFirstName("Chaitanya");
        user.setEmail("chai@example.com");
        user.setPassword("password123");
        userRepository.save(user);

        // When
        boolean exists = userRepository.existsByEmail("chai@example.com");

        // Then
        assertThat(exists).isTrue();
    }

    @Test
    @DisplayName("Should return false when email does not exist")
    void testExistsByEmailFalse()
    {
        // When
        boolean exists = userRepository.existsByEmail("nonexistent@example.com");

        // Then
        assertThat(exists).isFalse();
    }
}
