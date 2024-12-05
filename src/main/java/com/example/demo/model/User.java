package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @NotEmpty(message = "Apellido Paterno es Obligatorio")
        @Column(name = "first_name")
        private String firstName;

        @NotEmpty(message = "Apellido Materno es Obligatorio")
        @Column(name = "last_name")
        private String lastName;

        private String direction;

        @Column(unique = true)
        private String dni;

        @NotEmpty(message = "El Correo es Obligatorio")
        @Size(min = 7, max = 20, message = "El Correo debe tener entre 7 y 20 caracteres")
        @Column(unique = true, nullable = true)
        private String email;

        private String password;

        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(
                name = "user_role",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
        )
        private Collection<Role> roles;

        public User() {
        }

        public User(Long id, String name, String firstName, String lastName, String direction, String dni, String email, String password, Collection<Role> roles) {
                this.id = id;
                this.name = name;
                this.firstName = firstName;
                this.lastName = lastName;
                this.direction = direction;
                this.dni = dni;
                this.email = email;
                this.password = password;
                this.roles = roles;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getDirection() {
                return direction;
        }

        public void setDirection(String direction) {
                this.direction = direction;
        }

        public String getDni() {
                return dni;
        }

        public void setDni(String dni) {
                this.dni = dni;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Collection<Role> getRoles() {
                return roles;
        }

        public void setRoles(Collection<Role> roles) {
                this.roles = roles;
        }
}
