import com.feature.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Sylvain on 15/12/2015.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class PutMethodTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private final String payload = "{\"username\": \"sylvain.mars\", \"nom\": \"mars\", \"prenom\": \"sylvain\", \"pays\": { \"id\":\"1\"},\"role\": {\"id\":\"1\"}}";

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    /**
     * Update subressources of my User entity
     * method PUT
     * content-type : "application/json"
     * Expected behavior : should return 409 error
     * @throws Exception
     */
    @Test
    public void shouldBeKOWhileUpdatingSubResourcesWithPUTMethodAndJSONContenType() throws Exception {
        this.mockMvc.perform(put("/users/1")
                .content(payload)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isConflict());
    }


    /**
     * Update subressources of my User entity
     * method PUT
     * content-type : "application/patch+json"
     * Expected behavior : should return 409 error but return 204
     * @throws Exception
     */
    @Test
    public void shouldBeKOWhileUpdatingSubResourcesWithPUTMethodAndPatchPlusJsonContentType() throws Exception {
        this.mockMvc.perform(put("/users/1")
                .content(payload)
                .contentType("application/patch+json"))
                .andExpect(status().isConflict());
    }


    /**
     * Update subressources of my User entity
     * method PUT
     * content-type : "application/merge-patch+json"
     * Expected behavior : should return 409 error but return 204
     * @throws Exception
     */
    @Test
    public void shouldBeKOWhileUpdatingSubResourcesWithPUTMethodAndMergeMinusPatchPlusJsonContentType() throws Exception {
        this.mockMvc.perform(put("/users/1")
                .content(payload)
                .contentType("application/merge-patch+json"))
                .andExpect(status().isConflict());
    }
}
