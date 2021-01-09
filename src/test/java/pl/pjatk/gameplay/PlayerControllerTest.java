package pl.pjatk.gameplay;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.pjatk.gameplay.Service.PlayerService;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PlayerService playerService;

    @Test
    void shouldReturnEmptyList() throws Exception {
        mockMvc.perform(get("/player")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void shouldMatchContentFotHello() throws Exception {
        mockMvc.perform(get("/player/hello"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello world")));
    }


}