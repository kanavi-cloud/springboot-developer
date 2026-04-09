import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc // MockMvc 객체를 자동으로 구성하고 빈으로 등록해줌.
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc; // 스프링으로부터 의존성 주입을 받아 바로 사용

    @Test
    @DisplayName("사용자 조회 API 테스트")
    void getUserTest() throws Exception {
        // 가상의 클라이언트 요청                 .andExpect(jsonPath("$.name").value("Ramesh")) // 3. 응답 JSON의 'name' 값이 "Ramesh"인지 검증
               .andDo(print());                    // 4. 요청 및 응답
    }