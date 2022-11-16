
# Các sử dụng DucktorBE API

## GET: localhost:8080/ducktor/search

- Example: localhost:8080/ducktor/search?category=anal
- RequestParam: category
- Respond example:
  ```
  {
    "significantLink": [
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
  }

## GET: localhost:8080/ducktor/details
- Example http://localhost:8080/ducktor/details?url=https://api.nhs.uk/conditions/anal-cancer/
- RequestParam: url
- Respond example:
  ```
  {
    "name": "Anal cancer",
    "overview": "Anal cancer is a rare type of cancer that affects the anus (where your bowel connects to the outside of your body).",
    "symptoms": "Symptoms of anal cancer include bleeding, discharge, lumps and itching inside and outside the anus.",
    "cause": "Most anal cancers are caused by human papillomavirus (HPV). HPV is a common virus you can get from sex or skin-to-skin contact of the genital area.",
    "treatment": "Anal cancer can usually be treated with chemotherapy, radiotherapy or surgery, depending on the size of the cancer and how far it has spread.",
    "diagnosis": "To check for anal cancer, you may have a test where a thin tube with a camera is put into your bottom and a small sample from your anus is removed.",
    "prevention": "It’s not always possible to prevent anal cancer. Having the HPV vaccine, using a condom during sex and quitting smoking may help."
  }

