#!/bin/bash

# Configuration
BASE_URL="http://localhost:8090"
LOGIN_ENDPOINT="/usuario/login"
TAREFAS_ENDPOINT="/tarefas/eventos"

# Default user credentials from application.properties
EMAIL="michaeljackson@gmail.com"
SENHA="12345Michael"

# Date range for the request (example: current month)
DATA_INICIAL="2026-04-01T00:00:00"
DATA_FINAL="2026-04-30T23:59:59"

echo "Logging in to get JWT token..."

# Login request
LOGIN_RESPONSE=$(curl -s -X POST "$BASE_URL$LOGIN_ENDPOINT" \
  -H "Content-Type: application/json" \
  -d "{\"email\":\"$EMAIL\",\"senha\":\"$SENHA\"}")

# Extract token (assuming the response is just the JWT string)
TOKEN="$LOGIN_RESPONSE"

if [ -z "$TOKEN" ] || [ "$TOKEN" = "null" ]; then
  echo "Login failed. Response: $LOGIN_RESPONSE"
  exit 1
fi

echo "Login successful. Token obtained."

# Call the /tarefas/eventos endpoint
echo "Calling /tarefas/eventos endpoint..."

curl -X GET "$BASE_URL$TAREFAS_ENDPOINT?dataInicial=$DATA_INICIAL&dataFinal=$DATA_FINAL" \
  -H "Authorization: Bearer $TOKEN" \
  -H "Content-Type: application/json"

echo -e "\n\nRequest completed."
