package facisa.cesed.br;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import webservice.Application;
import webservice.charge.ChargeController;
import webservice.evento.EventoController;
import webservice.informativo.InformativoController;
import webservice.task.TaskController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestesWebService {
	
	@Autowired
	private ChargeController chargeController;
	private EventoController eventoController;
	private InformativoController informativoController;
	private TaskController taskController;
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;

	@Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
	
	@Test
	public void contextLoads() {
		assertNotNull(chargeController);
		assertNotNull(eventoController);
		assertNotNull(informativoController);
		assertNotNull(taskController);
	}

}