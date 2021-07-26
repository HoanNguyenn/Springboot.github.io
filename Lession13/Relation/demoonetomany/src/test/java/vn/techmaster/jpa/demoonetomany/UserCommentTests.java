package vn.techmaster.jpa.demoonetomany;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import vn.techmaster.jpa.demoonetomany.entity.Comment;
import vn.techmaster.jpa.demoonetomany.entity.User;

@DataJpaTest

public class UserCommentTests {
  @Autowired
  private TestEntityManager tem;

  @BeforeEach
  public void insertPost() {
    User user1 = new User("user 1st");
    user1.addComment(new Comment("Gut!"));
    user1.addComment(new Comment("Pekfect!"));
    tem.persist(user1);
    tem.flush();
    // assertThat(user1.getComments()).hasSize(2);
  }

  @AfterEach
  public void afterEachTest() {
    tem.clear();
  }

  @Test
  @DisplayName("Xoá Comment")
  public void userRemovesComment() {
    User user2 = new User("user 2st");
    Comment comment1 = new Comment("Furchbar");
    Comment comment2 = new Comment("Wunderchone");
    user2.addComment(comment1);
    user2.addComment(comment2);
    tem.flush();

    user2.removeComment(comment1); 

    // assertThat(user2.getComment()).hasSize(1); 
  }

  // @Test
  // @DisplayName("Cập nhật User")
  // public void getUpdateVersion() {
  //   Comment comment3 = new Comment("Leise");
  //   User user3 = new User();
  //   user3.addComment(comment3);
  //   tem.persist(user3);
  //   tem.flush();
  //   System.out.println(user3);
  //   User user3retrieved = tem.find(User.class, user3.getId());

  //   user3retrieved.setName("Heimand");
  //   tem.flush();

  //   System.out.println(user3retrieved);
  //   assertThat(user3retrieved.getVersion()).isEqualTo(1);

  //   user3retrieved.setName("Elmal");
  //   tem.flush();
  //   assertThat(user3retrieved.getVersion()).isEqualTo(2);
  // }


}