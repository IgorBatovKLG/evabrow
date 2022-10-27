package ru.mse.service.Services;

import ru.mse.service.DTO.MailDTO;
import ru.mse.service.DTO.MailDTO.MailDTOBuilder;
import ru.mse.service.Models.MailModel;

import java.util.ArrayList;

public class DTOServiceMail {

    public MailDTO toDTO(MailModel model){
        String sexAndName = "НЕ УКАЗАН ПОЛ!";
        ArrayList<String> strings = new ArrayList<>();
        String[] s = model.getPatientPersonAge().split(" ");
        int age = Integer.parseInt(s[0]);
        String[] s1 = model.getPatientRepPersonLastName().split(" ");
        String period = "";
        if(!model.getInvalidityGroupName().isBlank()){
            String name = model.getInvalidityPeriodId();
            if (!(model.getInvalidityPeriodId() ==null)){
                if (name.contains("на 1 год")) {
                    period = " сроком на один год ";
                }
                else if (name.contains("на 2 года")) {
                    period = " сроком на два года";
                }
                else if (name.contains("на 5 лет")){
                    period = " сроком на пять лет";
                }
                else if (name.contains("до 18 лет")) {
                    period = " до 18 лет ";
                }
                else if (name.contains("до 14 лет")) {
                    period = " до 14 лет ";
                }
                else if (name.contains("бессрочно")) {
                    period = " бессрочно ";
                }

            }


        }
        if (model.getPersonGender().equals("ЖЕН")){
            sexAndName = "Уважаемая " + model.getFirstName() + " " + model.getSecondName() + "!";
        } else {
            sexAndName = "Уважаемый " + model.getFirstName() + " " + model.getSecondName() + "!";
        }
        if (s1.length>2){
            sexAndName = "Уважаемый(ая) " + s1[1] + " " + s1[2];
        }
        String fullName = model.getLastName() + " " + model.getFirstName() +  " " + model.getSecondName();
        String paragraf1 = "";
        if (model.getPurposesXml().contains("установления")) {
            if (model.getInvalidityGroupName().equals("Инвалидность не установлена")) {
                //взрослые вне
                paragraf1 = "Согласно Постановлению Правительства Российской Федерации от 05 апреля 2022г. № 588 «О Признании лица инвалидом» Вы были освидетельствованы " + model.getDecisionDate() + " в " + model.getExamBuroName().toLowerCase() + ". По результатам проведения медико-социальной экспертизы принято решение: " + model.getInvalidityGroupName().toLowerCase() + period + ".";
            } else {
                //взрослые группа
                paragraf1 = "Согласно Постановлению Правительства Российской Федерации от 05 апреля 2022г. № 588 «О Признании лица инвалидом» Вы были освидетельствованы " + model.getDecisionDate() + " в " + model.getExamBuroName().toLowerCase() + ". По результатам проведения медико-социальной экспертизы Вам установлена " + model.getInvalidityGroupName().toLowerCase() + period + " и разработана индивидуальная программа реабилитации или абилитации инвалида(ИПРА).";

                if (s1.length>1){
                    paragraf1 = "Согласно Постановлению Правительства Российской Федерации от 05 апреля 2022г. № 588 «О Признании лица инвалидом» Гражданин " + fullName + " опекуном которого вы являетесь был освидетельствован " + model.getDecisionDate() + " в " + model.getExamBuroName().toLowerCase() + ". По результатам проведения медико-социальной экспертизы принято решение: " + model.getInvalidityGroupName().toLowerCase() + period + " и разработана индивидуальная программа реабилитации или абилитации инвалида(ИПРА).";
                    fullName = model.getPatientRepPersonLastName();
                }
            }
            if (age < 18 & s1.length > 2) {
                if (model.getInvalidityGroupName().equals("Инвалидность не установлена")) {
                    //Дети не признан
                    paragraf1 = "Согласно Постановлению Правительства Российской Федерации от 05 апреля 2022г. № 588 «О Признании лица инвалидом» Ваш ребенок " + fullName + " был освидетельствован " + model.getDecisionDate() + " в " + model.getExamBuroName().toLowerCase() + ". По результатам проведения медико-социальной экспертизы принято решение: " + model.getInvalidityGroupName().toLowerCase() + period + ".";
                    fullName = model.getPatientRepPersonLastName();
                } else {
                    //дети группа
                    paragraf1 = "Согласно Постановлению Правительства Российской Федерации от 05 апреля 2022г. № 588 «О Признании лица инвалидом» Ваш ребенок " + fullName + " был освидетельствован " + model.getDecisionDate() + " в " + model.getExamBuroName().toLowerCase() + ". По результатам проведения медико-социальной экспертизы установлена " + model.getInvalidityGroupName().toLowerCase() + period + " и разработана индивидуальная программа реабилитации или абилитации (ИПРА).";
                    fullName = model.getPatientRepPersonLastName();
                }
            }
        }else {
            if (model.getInvalidityGroupName().equals("Инвалидность не установлена")) {
                //не признан ипра
                paragraf1 = "Согласно Постановлению Правительства Российской Федерации от 05 апреля 2022г. № 588 «О Признании лица инвалидом» Вы были освидетельствованы " + model.getDecisionDate() + " в " + model.getExamBuroName().toLowerCase() + ". По результатам проведения медико-социальной экспертизы принято решение: " + model.getInvalidityGroupName().toLowerCase() + period + ".";
            } else {
                //Только ипра
                paragraf1 = "Согласно Постановлению Правительства Российской Федерации от 05 апреля 2022г. № 588 «О Признании лица инвалидом» Вы были освидетельствованы " + model.getDecisionDate() + " в " + model.getExamBuroName().toLowerCase() + ". По результатам проведения медико-социальной экспертизы разработана индивидуальная программа реабилитации или абилитации инвалида (ИПРА).";

                if (s1.length>1){
                    paragraf1 = "Согласно Постановлению Правительства Российской Федерации от 05 апреля 2022г. № 588 «О Признании лица инвалидом» Гражданин " + fullName + " опекуном которого вы являетесь был освидетельствован " + model.getDecisionDate() + " в " + model.getExamBuroName().toLowerCase() + ". По результатам проведения медико-социальной экспертизы разработана индивидуальная программа реабилитации или абилитации инвалида (ИПРА).";
                    fullName = model.getPatientRepPersonLastName();

                }

            }
            if (age < 18 & s1.length > 2) {
                //ребёнок не признан
                if (model.getInvalidityGroupName().equals("Инвалидность не установлена")) {
                    paragraf1 = "Согласно Постановлению Правительства Российской Федерации от 05 апреля 2022г. № 588 «О Признании лица инвалидом» Ваш ребенок  " + fullName + "  был освидетельствован " + model.getDecisionDate() + " в " + model.getExamBuroName().toLowerCase() + ". По результатам проведения медико-социальной экспертизы принято решение: " + model.getInvalidityGroupName().toLowerCase() + period + ".";
                    fullName = model.getPatientRepPersonLastName();
                } else {
                    //ребенок только ипра
                    paragraf1 = "Согласно Постановлению Правительства Российской Федерации от 05 апреля 2022г. № 588 «О Признании лица инвалидом» Ваш ребенок " + fullName + " был освидетельствован " + model.getDecisionDate() + " в " + model.getExamBuroName().toLowerCase() + ". По результатам проведения медико-социальной экспертизы разработана индивидуальная программа реабилитации или абилитации (ИПРА).";
                    fullName = model.getPatientRepPersonLastName();
                }
            }
        }

        strings.add(paragraf1);
        String paragraf2 = "В случае несогласия с решением бюро медико-социальной экспертизы гражданин (его законный или уполномоченный представитель) в месячный срок со дня получения решения может обжаловать его в главное бюро, в случае несогласия с решением главного бюро — в месячный срок в Федеральное бюро МСЭ. Решения бюро, главного бюро, Федерального бюро могут быть обжалованы в суд в порядке, установленном законодательством Российской Федерации.";


        String paragraf3 = "Приложение:";

        try {


            if (model.getBlankNumber().isBlank()
                    & model.getIpraChildNumber().isBlank()
                    & model.getIpraNumber().isBlank()) {
                paragraf3 = "";
            }
        } catch (NullPointerException e){
            paragraf3 = "";
        }


        strings.add(paragraf2);
        strings.add(paragraf3);

        int id = 1;
        try {

            if (!model.getBlankNumber().isBlank()){
                String paragraf6 = id + ". Справка " + model.getBlankNumber();
                strings.add(paragraf6);
                id++;
            }
        } catch (NullPointerException e) {}
        if (!model.getIpraChildNumber().isBlank()){
            String paragraf6 = id + ". ИПРА " + model.getIpraChildNumber();
            strings.add(paragraf6);
            id++;
        }

        if (!model.getIpraNumber().isBlank()){
            String paragraf6 = id + ". ИПРА " + model.getIpraNumber();
            strings.add(paragraf6);
            id++;
        }
        String typeManager = "Руководитель бюро медико-социальной экспертизы";
        if (model.getExamBuroName().toLowerCase().contains("состав")){
            typeManager = "Руководитель экспертного состава медико-социальной экспертизы";
            model.setBuroManagerName(model.getExpSostavManagerName());
        }
        MailDTO dto = MailDTO.builder()
                .adres(model.getAddress())
                .fullName(fullName)
                .sexAndName(sexAndName)
                .paragraphs(strings)
                .buroOrrSostav(typeManager)
                .ManagerName(model.getBuroManagerName())
                .executor("")
                .id("")
                .InvalidityPeriodId("")
                .build();
        return dto;
    }
}
