package homify.test.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.professional.controller.ProjectController;
import com.professional.service.ProjectService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ProjectControllerTest {

	@Mock
	private ProjectService projectService;

	@InjectMocks
	private ProjectController projectController;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);

		this.mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
	}

	@Test
	public void testDeleteProject() throws Exception {
		mockMvc = standaloneSetup(projectController).build();
		mockMvc.perform(delete("/deleteProject/23")).andExpect(content().string("Project Deleted"));
	}

}
