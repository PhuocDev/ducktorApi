package com.example.docktor_mobile.controllers;

import com.example.docktor_mobile.models.Desease;
import com.example.docktor_mobile.models.TopLink;
import com.example.docktor_mobile.services.DeseaseService;
import com.example.docktor_mobile.services.TopLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping("/ducktor")
public class MainController {
    @Autowired
    TopLinkService topLinkService;

    @Autowired
    DeseaseService deseaseService;

    @GetMapping("/search")
    public ArrayList<TopLink> getTopLinksWithKeyword(@RequestParam String category) {
        ArrayList<TopLink> topLinks = new ArrayList<>();

        String uri = "https:"+"//ap"+"i.nhs.u"+"k/cond" + "itions/"+"?category=" + category + "&gen"+"re=condition&subs"+"cription-key=4d5efa5"+"f571f4c4abed9f546d9e2ab81";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        topLinks = topLinkService.getLinksFromJson(jsonObject);

        return topLinks;
    }

    @GetMapping("/details")
    public Desease detailsDesease(@RequestParam String url) {
        Desease desease = new Desease();
        String uri2 = url + "?subsc"+"ription-key=4d5ef"+"a5f571f4c4abed9f5"+"46d9e2ab81";
        RestTemplate restTemplate = new RestTemplate();
        //get json from api
        String jsonString = restTemplate.getForObject(uri2, String.class);
        desease = deseaseService.getInformationFromJson(jsonString);
        return desease;
    }

    @GetMapping("/test")
    public Desease detailsDeseaseTest() {
        Desease desease = new Desease();
        String uri2 = "1231" + "?subscripti"+"on-key=4d5efa5f"+"571f4c4abed9f546d9e2ab81";
        RestTemplate restTemplate = new RestTemplate();

        //get json from api
        String jsonString = sampleJsonResult ;
        //test bằng json demo
        //jsonString = sampleJsonResult;
        //System.out.println(jsonString);
        desease = deseaseService.getInformationFromJson(jsonString);
        return desease;
    }
    public static String sampleJsonResult = "{\n" +
            "    \"@context\": \"http://schema.org\",\n" +
            "    \"@type\": \"MedicalWebPage\",\n" +
            "    \"name\": \"Anal cancer\",\n" +
            "    \"copyrightHolder\": {\n" +
            "        \"name\": \"Crown Copyright\",\n" +
            "        \"@type\": \"Organization\"\n" +
            "    },\n" +
            "    \"license\": \"https://developer.api.nhs.uk/terms\",\n" +
            "    \"author\": {\n" +
            "        \"url\": \"https://www.nhs.uk\",\n" +
            "        \"logo\": \"https://www.nhs.uk/nhscwebservices/documents/logo1.jpg\",\n" +
            "        \"email\": \"nhswebsite.servicedesk@nhs.net\",\n" +
            "        \"@type\": \"Organization\",\n" +
            "        \"name\": \"NHS website\"\n" +
            "    },\n" +
            "    \"about\": {\n" +
            "        \"@type\": \"WebPage\",\n" +
            "        \"name\": \"Anal cancer\",\n" +
            "        \"alternateName\": \"\"\n" +
            "    },\n" +
            "    \"description\": \"Anal cancer is a rare type of cancer that affects the anus. Get information and advice about symptoms, causes and treatments.\",\n" +
            "    \"url\": \"https://api.nhs.uk/conditions/anal-cancer/\",\n" +
            "    \"genre\": [\n" +
            "        \"Condition\"\n" +
            "    ],\n" +
            "    \"keywords\": [],\n" +
            "    \"lastReviewed\": [\n" +
            "        \"2021-03-08T01:00:00+00:00\",\n" +
            "        \"2024-03-08T01:00:00+00:00\"\n" +
            "    ],\n" +
            "    \"breadcrumb\": {\n" +
            "        \"@context\": \"http://schema.org\",\n" +
            "        \"@type\": \"BreadcrumbList\",\n" +
            "        \"itemListElement\": [\n" +
            "            {\n" +
            "                \"@type\": \"ListItem\",\n" +
            "                \"position\": 0,\n" +
            "                \"item\": {\n" +
            "                    \"@id\": \"https://api.nhs.uk/conditions/\",\n" +
            "                    \"name\": \"Health A to Z\",\n" +
            "                    \"genre\": []\n" +
            "                }\n" +
            "            },\n" +
            "            {\n" +
            "                \"@type\": \"ListItem\",\n" +
            "                \"position\": 1,\n" +
            "                \"item\": {\n" +
            "                    \"@id\": \"https://api.nhs.uk/conditions/anal-cancer/\",\n" +
            "                    \"name\": \"Anal cancer\",\n" +
            "                    \"genre\": [\n" +
            "                        \"Condition\"\n" +
            "                    ]\n" +
            "                }\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"dateModified\": \"2022-07-12T15:04:44+00:00\",\n" +
            "    \"hasPart\": [\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/#overview\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/OverviewHealthAspect\",\n" +
            "            \"headline\": \"\",\n" +
            "            \"description\": \"Anal cancer is a rare type of cancer that affects the anus (where your bowel connects to the outside of your body).\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"text\": \"<p>Symptoms of anal cancer include bleeding, discharge, lumps and itching inside and outside the anus.</p> \",\n" +
            "                    \"@type\": \"WebPageElement\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"text\": \"<p>Anal cancer can usually be treated with chemotherapy, radiotherapy or surgery, depending on the size of the cancer and how far it has spread.</p> \",\n" +
            "                    \"@type\": \"WebPageElement\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"text\": \"<p>Most anal cancers are caused by human papillomavirus (HPV). HPV is a common virus you can get from sex or skin-to-skin contact of the genital area.</p> \",\n" +
            "                    \"@type\": \"WebPageElement\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/symptoms/#symptoms\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/SymptomsHealthAspect\",\n" +
            "            \"headline\": \"Main symptoms of anal cancer\",\n" +
            "            \"description\": \"Symptoms of anal cancer include bleeding, discharge, lumps and itching inside and outside the anus.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p>Symptoms of anal cancer can include:</p><ul><li>bleeding from the bottom</li><li>itching and <a href=\\\"https://api.nhs.uk/conditions/anal-pain/\\\">pain around the anus</a></li><li>small lumps around and inside the bottom</li><li>a discharge of mucus from the bottom</li><li>having problems controlling when you poo (<a href=\\\"https://api.nhs.uk/conditions/bowel-incontinence/\\\">bowel incontinence</a>)</li><li>needing to poo often with looser, runnier poos</li></ul><p>Anal cancer may have no symptoms at all, or they might be hard to spot.</p><p>Anal cancer symptoms are often similar to piles (<a href=\\\"https://api.nhs.uk/conditions/piles-haemorrhoids/\\\">haemorrhoids</a>) and <a href=\\\"https://api.nhs.uk/conditions/anal-fissure/\\\">anal fissures</a>, which are common and less serious conditions.</p>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/symptoms/#non-urgent-medical-help\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/MedicalHelpNonurgentHealthAspect\",\n" +
            "            \"headline\": \"\",\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"identifier\": \"primary\",\n" +
            "                    \"headline\": \"See a GP if you:\",\n" +
            "                    \"text\": \"<ul>\\n<li>\\n  have symptoms of anal cancer\\n </li>\\n<li>\\n  notice a change around your anus that is not normal for you\\n </li>\\n</ul>\\n\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/causes/#causes\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/CausesHealthAspect\",\n" +
            "            \"headline\": \"Who is more likely to get anal cancer\",\n" +
            "            \"description\": \"Most anal cancers are caused by human papillomavirus (HPV). HPV is a common virus you can get from sex or skin-to-skin contact of the genital area.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p></p><p>Most anal cancers are caused by an infection called <a href=\\\"https://api.nhs.uk/conditions/human-papilloma-virus-hpv/\\\">human papillomavirus (HPV</a>).</p><p>You can get HPV from:</p><ul><li>any skin-to-skin contact of the genital area</li><li>vaginal, anal or oral sex</li><li>sharing sex toys</li></ul><p>Anal cancer is rare. Most people affected by HPV will not develop cancer.</p><p>You may be more likely to get anal cancer if you:</p><ul><li>have anal sex</li><li>are over the age of 75</li><li>smoke</li><li>have had cervical or vaginal cancer</li><li>have a weakened immune system, such as from HIV or an organ transplant</li></ul><p></p>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/causes/#prevention\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/PreventionHealthAspect\",\n" +
            "            \"headline\": \"How to reduce your risk of getting anal cancer\",\n" +
            "            \"description\": \"It’s not always possible to prevent anal cancer. Having the HPV vaccine, using a condom during sex and quitting smoking may help.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p>You cannot always prevent anal cancer. HPV vaccination is one of the best ways to protect against anal cancer.</p><p>All children aged 12 to 13 are offered the <a href=\\\"https://api.nhs.uk/conditions/vaccinations/hpv-human-papillomavirus-vaccine/\\\">HPV vaccine</a>. It helps protect against cancers caused by HPV, as well as genital warts.</p><p>There are also healthy changes you can make to lower your chances of getting anal cancer.</p>\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"Do\",\n" +
            "                    \"text\": \"<ul><li><p>use a condom when having sex to lower your chances of getting <a href=\\\"https://api.nhs.uk/conditions/human-papilloma-virus-hpv/\\\">HPV</a></p></li><li><p>keep sex toys clean and do not share them</p></li><li><p>try to <a href=\\\"https://www.nhs.uk/live-well/quit-smoking/\\\">quit smoking</a></p></li></ul>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/tests-and-next-steps/#diagnosis\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/DiagnosisHealthAspect\",\n" +
            "            \"headline\": \"Main tests for anal cancer\",\n" +
            "            \"description\": \"To check for anal cancer, you may have a test where a thin tube with a camera is put into your bottom and a small sample from your anus is removed.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p>You might have some tests and scans to check for anal cancer if a GP refers you to a specialist.</p><p>The tests you have will depend on your symptoms.</p><p>The tests may include:</p><ul><li>putting a thin tube with a camera and light into your bottom to check for any changes</li><li>taking a small sample from your anus (<a href=\\\"https://api.nhs.uk/conditions/biopsy/\\\">biopsy</a>) so it can be looked at in a laboratory under a microscope</li><li>blood tests</li></ul>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/treatment/#medical-treatments\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/TreatmentsHealthAspect\",\n" +
            "            \"headline\": \"Treatment for anal cancer\",\n" +
            "            \"description\": \"Anal cancer can usually be treated with chemotherapy, radiotherapy or surgery, depending on the size of the cancer and how far it has spread.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p>Anal cancer is often treatable when found early.</p><p>The treatment you have for anal cancer will depend on:</p><ul><li>the size of the cancer</li><li>where it is</li><li>if it has spread</li><li>your general health</li></ul><p></p><p>The main treatment for anal cancer is a combination of radiotherapy and chemotherapy, called chemoradiation (or chemoradiotherapy).</p><p>Other treatments include chemotherapy or radiotherapy on their own, and surgery.</p><p>The specialist care team looking after you will:</p><ul><li>explain the treatments, benefits and side effects</li><li>work with you to create a treatment plan that is best for you</li><li>help you manage any side effects, including any changes to your diet</li></ul><p>You'll have regular check-ups during and after any treatments. You may also have tests and scans.</p><p>If you have any symptoms or side effects that you are worried about, talk to your specialists. You do not need to wait for your next check-up.</p><p></p>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"relatedLink\": [\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 0,\n" +
            "            \"name\": \"Anal cancer\",\n" +
            "            \"alternativeHeadline\": \"Overview\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/symptoms/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 1,\n" +
            "            \"name\": \"Symptoms\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/causes/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 2,\n" +
            "            \"name\": \"Causes\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/tests-and-next-steps/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 3,\n" +
            "            \"name\": \"Tests and next steps\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/treatment/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 4,\n" +
            "            \"name\": \"Treatment\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/where-to-find-help-and-support/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 5,\n" +
            "            \"name\": \"Where to find help and support\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"contentSubTypes\": [],\n" +
            "    \"mainEntityOfPage\": [\n" +
            "        {\n" +
            "            \"identifier\": \"0\",\n" +
            "            \"name\": \"section heading\",\n" +
            "            \"position\": 0,\n" +
            "            \"@type\": \"WebPageElement\",\n" +
            "            \"mainEntityOfPage\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"identifier\": \"1\",\n" +
            "                    \"text\": \"<ul><li>Anal cancer is a rare type of cancer that affects the anus.</li><li>The anus is where your bowel connects to the outside of your body (the bottom).</li><li>Anal cancer can start in any part of the anus.</li><li>How serious anal cancer is depends on where it starts, how big it is, if it spreads and your general health.</li></ul>\",\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"markdown\",\n" +
            "                    \"headline\": \"\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"identifier\": \"1\",\n" +
            "                    \"text\": \"<ul><li>Anal cancer is a rare type of cancer that affects the anus.</li><li>The anus is where your bowel connects to the outside of your body (the bottom).</li><li>Anal cancer can start in any part of the anus.</li><li>How serious anal cancer is depends on where it starts, how big it is, if it spreads and your general health.</li></ul>\",\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"markdown\",\n" +
            "                    \"headline\": \"\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"identifier\": \"0\",\n" +
            "            \"name\": \"section heading\",\n" +
            "            \"position\": 1,\n" +
            "            \"@type\": \"WebPageElement\",\n" +
            "            \"mainEntityOfPage\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"Callout\",\n" +
            "                    \"identifier\": \"4\",\n" +
            "                    \"text\": \"<h2>Get your symptoms checked</h2><p>It's important to get any symptoms of anal cancer checked as soon as possible. Finding it early can make it more treatable.</p>\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"Callout\",\n" +
            "                    \"identifier\": \"4\",\n" +
            "                    \"text\": \"<h2>Get your symptoms checked</h2><p>It's important to get any symptoms of anal cancer checked as soon as possible. Finding it early can make it more treatable.</p>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"alternativeHeadline\": \"Overview\"\n" +
            "}";
}
