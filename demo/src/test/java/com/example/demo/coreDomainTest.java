// package com.example.demo;

// import static org.assertj.core.api.Assertions.*;
// import org.junit.jupiter.api.Test;

// public class coreDomainTest {
//     @Test
//     void checkNewVideoattributes() {
//         VideoEntity video = new VideoEntity("title", "content", "alice");
//         assertThat(video.getName()).isEqualTo("title");
//         assertThat(video.getId()).isNull();
//         assertThat(video.getDescription()).isEqualTo("content");
//     }

//     @Test
//     void checkToStringFunction() {
//         VideoEntity video = new VideoEntity("title", "content", "alice");
//         assertThat(video.toString())
//                 .isEqualTo("VideoEntity [id=null, name=title, description=content, username=alice]");
//     }

//     @Test
//     void settersShouldMutateState() {
//         VideoEntity entity = new VideoEntity("title",
//                 "description", "alice");
//         entity.setId(99L);
//         entity.setName("new name");
//         entity.setDescription("new desc");
//         entity.setUsername("bob");
//         assertThat(entity.getId()).isEqualTo(99L);
//         assertThat(entity.getUsername()).isEqualTo("bob");
//         assertThat(entity.getName()).isEqualTo("new name");
//         assertThat(entity.getDescription()).isEqualTo("new desc");
//     }
// }