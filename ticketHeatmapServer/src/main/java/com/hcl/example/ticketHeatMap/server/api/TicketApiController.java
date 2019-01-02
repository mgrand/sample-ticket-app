package com.hcl.example.ticketHeatMap.server.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.example.ticketHeatMap.server.model.Ticket;
import com.hcl.example.ticketHeatMap.server.model.TicketHeatmapSource;
import com.hcl.example.ticketHeatMap.server.model.mockDataSource.MockTicketHeatmapDataSource;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class TicketApiController implements TicketApi {

    private static final Logger log = LoggerFactory.getLogger(TicketApiController.class);

    private final TicketHeatmapSource ticketSource;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TicketApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        ticketSource = new MockTicketHeatmapDataSource(objectMapper);
        this.request = request;
    }

    @SuppressWarnings("DefaultAnnotationParam")
    public ResponseEntity<List<Ticket>> getTicketsForHeatmap(@ApiParam(value = "identify the regions to be returned", required = true) @RequestParam(value = "regions", required = true) List<String> regions,
                                                             @ApiParam(value = "Ticket statuses to include.", allowableValues = "any, closed, open", defaultValue = "any") @Valid @RequestParam(value = "status", required = false, defaultValue = "any") String status) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.equals("*/*"))) {
            log.info("Serving regions {}; status = {}", regions, status);
            List<Ticket> tickets = ticketSource.getTickets(regions, status);
            log.info("Returning {} tickets.", tickets.size());
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        }
        log.warn("Unable to serve accepable content type {}", accept);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
