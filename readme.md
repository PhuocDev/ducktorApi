
#Các sử dụng DucktorBE API

## GET: localhost:8080/ducktor/search

- Example: localhost:8080/ducktor/search?category=anal
- RequestParam: category
- Respond example:
  ```
  [
    {
    "name": "Mouth ulcers",
    "description": "Find out about mouth ulcers, including what they look like, what causes them, how to treat them, and how to avoid getting them.",
    "url": "https://api.nhs.uk/conditions/mouth-ulcers/"
    },
    {
    "name": "Mouth cancer",
    "description": "Read about mouth cancer, also known as oral cancer, including information about symptoms, types, causes, treatment, possible complications and reducing the risks.",
    "url": "https://api.nhs.uk/conditions/mouth-cancer/"
    }
  ]

## GET: localhost:8080/ducktor/search
- Example http://localhost:8080/ducktor/details?url=https://api.nhs.uk/conditions/mouth-ulcers/
- RequestParam: url
- Respond example:
  ```
  [
    {
    "name": "Legionnaires' disease",
    "description": "Read about Legionnaires' disease, an uncommon but serious lung infection you can get from inhaling droplets of water that contains Legionella bacteria.",
    "url": "https://api.nhs.uk/conditions/legionnaires-disease/"
    },
    {
    "name": "Leg cramps",
    "description": "Read about leg cramps, a common condition where the muscles in the leg suddenly become tight and painful.",
    "url": "https://api.nhs.uk/conditions/leg-cramps/"
    }
  ]

