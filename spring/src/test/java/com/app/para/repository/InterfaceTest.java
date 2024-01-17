package com.app.para.repository;

import com.app.para.models.ApplicationUser;
import com.app.para.models.Friends;
import com.app.para.services.FriendsService;
import com.app.para.services.GameService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceTest {

    @Mock
    private FriendsRepo friendsRepo;

    @Test
    public void friends() {
        ApplicationUser owner = new ApplicationUser();
        ApplicationUser friendo = new ApplicationUser();
        ApplicationUser friendo2 = new ApplicationUser();
        Friends friends = new Friends(owner, friendo);
        Friends friends1 = new Friends(owner, friendo2);
        Friends friends2 = new Friends(friendo, friendo2);
        given(friendsRepo.findAll()).willReturn(List.of(friends, friends1, friends2));
        var  gameList = friendsRepo.findAll();
        assertThat(gameList.size()).isEqualTo(3);
        Assert.assertNotNull(friendsRepo.findFriendsById(1));
    }
}