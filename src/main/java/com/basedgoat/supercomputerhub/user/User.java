package com.basedgoat.supercomputerhub;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * The User class, containing the basic data for a user on the system.
 */
public class User {
    /**
     * The Unique Identifiable ID for the User
     */
    private Long id;
    /**
     * The username for the user, recognizable by whoever uses it
     */
    private String username;
    /**
     * To keep track of who is on the system and make sure that we only have authorized people
     */
    private int studentId;
    /**
     * the password of the account. right now this is stored as plaintext (REALLY BAD)
     * TODO: Implement hashing using Bcrypt to store the password
     */
    private String password;

    private static Long currentId = 0L;
    private static String generateSalt() {
        var time = new Date();
        return String.valueOf(time.getTime());
    }

    @Value("${spring.application.defaultPassword}")
    private static String defaultPassword;

    private static Long generateId() {
        Long temp = currentId;
        currentId++;
        return temp;
    }

    public User() {
        this.id = generateId();
        this.username = "Test user " + this.id;
        this.studentId = 0;
        this.password = defaultPassword;
    }

    public User(String username, int studentId, String password) {
        this.id = generateId();
        this.username =username;
        this.studentId = studentId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
