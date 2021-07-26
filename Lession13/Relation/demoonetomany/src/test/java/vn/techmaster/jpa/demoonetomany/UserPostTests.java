package vn.techmaster.jpa.demoonetomany;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import vn.techmaster.jpa.demoonetomany.entity.Post;
import vn.techmaster.jpa.demoonetomany.entity.User;

@DataJpaTest

public class UserPostTests {
  @Autowired
  private TestEntityManager tem;

  @Test
  public void insertPost() {
    String title = "Today's weather postcard";
    Post post1 = new Post(title);
    User user1 = new User();
    user1.addPost(post1);
    long post1_id = tem.persistAndGetId(post1, Long.class);
    tem.flush();
    Post retrievePost1 = tem.find(Post.class, post1_id);
    assertThat(retrievePost1).isEqualTo(post1);
    // assertThat(user1.getPost().hasSize(1));
  }

  @AfterEach
  public void afterEachTest() {
    tem.clear();
  }
  
  @Test
  @DisplayName("@Version tăng mỗi khi cập nhật Post")
  public void getUpdateVersion() {
    Post post2 = new Post("Italia vo dich");
    User user2 = new User();
    user2.addPost(post2);

    Post Post2retrieved = tem.find(Post.class, post2.getId());
    Post2retrieved.setTitle("Y vo dich euro 2021");
    tem.flush();

    assertThat(Post2retrieved.getVersion()).isEqualTo(1);

    Post2retrieved.setTitle("Y thang Anh tro thanh nha vo dich euro");
    tem.flush();
    assertThat(Post2retrieved.getVersion()).isEqualTo(2);
  }


}