package com.hcl.example.ticketHeatMap.server.model;

import java.util.List;

/**
 * Data source for tickets.
 */
public interface TicketHeatmapSource {
    /**
     * Get tickets from the data source that match the criteria specified by this method's parameters.
     *
     * @param regions Only tickets whose {@code region} field equals one of the values in this list will be returned.
     *                If this is an empty list, no tickets are returned.
     * @param status Only tickets whose status matches this value will be returned. If this parameter is null, then
     *               there is no filtering by status.
     * @return A list of the tickets that match the parameters.
     */
    List<Ticket> getTickets(List<String> regions, String status);
}
