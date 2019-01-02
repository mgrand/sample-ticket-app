package com.hcl.example.ticketHeatMap.server.model.mockDataSource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.example.ticketHeatMap.server.model.Ticket;
import com.hcl.example.ticketHeatMap.server.model.TicketHeatmapSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class MockTicketHeatmapDataSource implements TicketHeatmapSource {
    private static final Logger log = LoggerFactory.getLogger(MockTicketHeatmapDataSource.class);

    private static final String TEST_DATA_FILE = "/testData.json";

    private List<Ticket> tickets;

    /**
     * Constructor. Reads tickets as JSON from resource named {@value TEST_DATA_FILE}.
     */
    public MockTicketHeatmapDataSource(ObjectMapper objectMapper) {
        String jsonString = readDataAsString();
        try {
            //noinspection unchecked
            tickets = objectMapper.readValue(jsonString, new TypeReference<List<Ticket>>(){});
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private String readDataAsString() {
        log.info("Getting test data from resource named " + TEST_DATA_FILE);
        char[] buffer = new char[99999];
        try (Reader reader = new InputStreamReader(getDataInputStream(), StandardCharsets.UTF_8)) {
            int length = reader.read(buffer);
            return new String(buffer, 0, length);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private InputStream getDataInputStream() {
        InputStream fin = getClass().getResourceAsStream(TEST_DATA_FILE);
        if (fin == null) {
            String msg = "Unable to find resource named " + TEST_DATA_FILE;
            log.error(msg);
            throw new RuntimeException(msg);
        }
        return fin;
    }

    private boolean filterPredicate(Ticket ticket, List<String> regions, String status) {
        return (status == null || status.equalsIgnoreCase(ticket.getStatus().name())) && regions.contains(ticket.getRegion());
    }

    @Override
    public List<Ticket> getTickets(List<String> regions, String status) {
        return tickets.stream().filter((t)->filterPredicate(t,regions,status)).collect(Collectors.toList());
    }
}
