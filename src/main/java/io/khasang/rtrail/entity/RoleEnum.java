package io.khasang.rtrail.entity;

/**
 * USER role may send messages, create routs
 * MODERATOR role has USER role plus may moderate forum
 * ADMIN role has all roles plus may moderate application
 *
 * @author Ilya Bogachev
 * @since 14.06.2018
 */
public enum RoleEnum {
    ROLE_USER, ROLE_ADMIN, ROLE_MODERATOR;
}

