// package com.example.demo;

// import static org.mockito.Mockito.*;
// import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.security.test.context.support.WithMockUser;
// import org.springframework.test.web.servlet.MockMvc;

// @WebMvcTest(controllers = HomeController.class)
// public class HomeControllerTest {
//     @Autowired
//     private MockMvc mvc;
//     @MockBean
//     static private VideoService videoService;

//     @Test
//     @WithMockUser
//     void checkVideocreation() throws Exception {
//         mvc.perform(
//                 post("/new-video").param("name", "title").param("description", "content").with(csrf()))
//                 .andExpect(redirectedUrl("/"));
//         verify(videoService).create(
//                 new NewVideo("title", "content"), "user");
//     }
// }