import com.feature.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Sylvain on 15/12/2015.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class PatchMethodTest {

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
     * method PATCH
     * content-type : "application/merge-patch+json"
     * Expected behavior : should return 204 (no content)
     * @throws Exception
     */
    @Test
    public void shouldBeOKWhileUpdatingSubResourceWithPatchMethodAndMergeMinusPatchPlusJsonContentType() throws Exception {
        this.mockMvc.perform(patch("/users/1")
                .content(payload)
                .contentType("application/merge-patch+json"))
                .andExpect(status().isNoContent());
    }

    /**
     * Update subressources of my User entity
     * method PATCH
     * content-type : "application/patch+json"
     * Expected behavior : should return 204 (no content) ??? see my comments
     * @throws Exception
     */
    @Test
    public void shouldBeOKWhileUpdatingSubResourceWithPatchMethodAndPatchPlusJsonContentType() throws Exception {
        this.mockMvc.perform(patch("/users/1")
                .content(payload)
                .contentType("application/patch+json"))
                .andExpect(status().isNoContent());

        // I still don't know what should be this issue in this test. My payload should be contains operations.
        // And I didn't specify any specific operation but my test is working like a merge-patch+json

        /*

   [
     { "op": "test", "path": "/a/b/c", "value": "foo" },
     { "op": "remove", "path": "/a/b/c" },
     { "op": "add", "path": "/a/b/c", "value": [ "foo", "bar" ] },
     { "op": "replace", "path": "/a/b/c", "value": 42 },
     { "op": "move", "from": "/a/b/c", "path": "/a/b/d" },
     { "op": "copy", "from": "/a/b/d", "path": "/a/b/e" }
   ]
         */
    }
}
