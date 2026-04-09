import me.scpark.springdeveloper.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestClass {

    @Test
    @DisplayName("1 더하기 2는 3이다")
    void additionTest() {
        int a = 1;
        int b = 2;
        Calculator calc = new Calculator();

        int result = calc.add(a, b);
        assertThat(result).isEqualTo(3);
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /test 요청 시 Hello World반환")
    void getTestAPI() throws Exception {

        mockMvc.perform(get("/test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                .andDo(print());
    }

}