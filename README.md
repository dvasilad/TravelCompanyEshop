# Travel Company E-Shop Project

A Java-based platform that manages travel-related services for a company, including customers, itineraries, and ticketing.

## Key Features

- **Customer & Ticket Management**: Supports customer registration and ticket issuance with payment options (cash or credit card).
- **Itineraries**: Allows creating itineraries with departure/destination codes, dates, and pricing, validating airport codes.
- **Reports**: Generates summaries for:
    - Total ticket count and cost by customer.
    - Customers without tickets.
    - Offered itineraries per destination and departure.
    - Top customers by ticket count and spending.

## Structure

1. **Core Entities**: `Customer`, `Itinerary`, `Ticket`, and payment methods.
2. **Reports**: Various customer and itinerary statistics.
3. **Exceptions**: Handles errors like invalid emails or airport codes.
4. **Main Class**: Demonstrates customer creation, ticket processing, and report generation.

## Setup

1. Clone the project in IntelliJ, using https://github.com/dvasilad/TravelCompanyEshop.git
2. Use JDK 23.
