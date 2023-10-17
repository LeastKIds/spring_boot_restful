package io.namoosori.rest.service.logic;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;   // 직접 적어야 함

@SpringBootTest
public class UserServiceLogicTest {

    @Autowired // unit test에서는 이렇게만 주입을 해야함
    private UserService userService;

    private User kim;
    private User lea;

    @BeforeEach
    public void startUp() {
        this.kim = new User("kim", "kim@namoosori.io");
        this.lea = new User("lea", "lea@namoosori.io");
        this.userService.register(kim);
        this.userService.register(lea);
    }

    @Test
    public void register() {
        User sample = User.sample();

        assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(3);

        this.userService.remove(sample.getId());
    }

    @Test
    public void find() {
        assertThat(this.userService.find(lea.getId())).isNotNull();
        assertThat(this.userService.find(lea.getId()).getEmail()).isEqualTo(lea.getEmail());
    }

    @AfterEach
    public void cleanUp() {
        this.userService.remove(kim.getId());
        this.userService.remove(lea.getId());
    }

}
