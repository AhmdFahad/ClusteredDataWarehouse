# FX Deals Data Warehouse

## Overview
This project stores accepted FX deals into the Bloomberg data warehouse for analyzing the deals. The system ensures data validation, prevents duplicate entries, and persists the data in a PostgreSQL database.

## Technologies
- Java
- Spring Boot
- PostgreSQL
- Docker

## Setup
1. Clone the repository & change directory:
   ```sh
   git clone https://github.com/yourusername/fx-deals-data-warehouse.git
   cd fx-deals-data-warehouse

2. run the application:
   ```sh
   docker-compose up --build


## API
### Gat All Deals
- **URL**: `/v1/api/deals/`
- **Method**: `GET`


### Save Deal
- **URL**: `/v1/api/deals/`
- **Method**: `POST`
- **Body**:
```json
{
    "dealId": 123,
    "fromCurrencyIsoCode": "USD",
    "toCurrencyIsoCode": "EUR",
    "dealTimestamp": "2024-06-06T12:00:00Z",
    "dealAmount": 1111
}
```
**Description**: Saves a new FX deal to the data warehouse. All attributes are validated to ensure they are not null. The ISO currency codes are validated for correct format and existence. If a deal with the same dealId already exists, the system prevents duplication.

