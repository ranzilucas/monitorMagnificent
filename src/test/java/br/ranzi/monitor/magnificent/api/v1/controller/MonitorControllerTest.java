package br.ranzi.monitor.magnificent.api.v1.controller;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import br.ranzi.monitor.magnificent.api.v1.assembler.MonitorHistoryAssembler;
import br.ranzi.monitor.magnificent.api.v1.resource.MonitorResource;
import br.ranzi.monitor.magnificent.domain.orm.model.MonitorHistory;
import br.ranzi.monitor.magnificent.service.MonitorService;

@RunWith(MockitoJUnitRunner.class)
public class MonitorControllerTest {

    private static final String PATH_MONITOR = "/monitor";
    MonitorResource resource;
    MonitorHistory monitorHistory;
    @InjectMocks
    private MonitorController controller;
    @Mock
    private MonitorService service;
    @Mock
    private MonitorHistoryAssembler assembler;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(controller).build();
        resource = mock(MonitorResource.class);
        monitorHistory = mock(MonitorHistory.class);
    }

    @Test
    public void getHistory() throws Exception {
        List<MonitorHistory> historyList = new ArrayList<>();
        when(service.history()).thenReturn(historyList);
        when(assembler.toResource(monitorHistory)).thenReturn(resource);

        MockHttpServletRequestBuilder getRequest = get(PATH_MONITOR);

        ResultActions getResult = mockMvc.perform(getRequest);

        getResult.andExpect(status().isOk()).andReturn();
    }

}
