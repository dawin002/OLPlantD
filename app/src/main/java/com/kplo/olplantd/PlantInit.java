package com.kplo.olplantd;


import android.util.Log;

import java.util.Scanner;
import java.util.StringTokenizer;


class PlantInit {
    public static int MAX_SIZE_PLANT = 39; // 식물 최대 갯수,
    public static int MAX_SIZE_PLANT_CHARACTER = 18;
    public static PlntData plantDB[] = new PlntData[39]; // ******************* 선언위치 잘생각해봐라 ************ 다음에 오자마자하기
    // 전역변수로 식물특징 클레스 배열 선언

    public static void initDB(){
        // 파일을 입력받아서 객체 5천개 만든후 배열에 1번부터 저장하고 배열 넘기기
        //파일을 useDelimiter("#")을 이용하여 하나의 식물을 받아오고
        // tokenizer을 이용하여 각각의 특징을 하나씩 받아온다.

        String plantCharacter = "#@흰양귀비 @Papaver amurense N.Busch ex Tolm. @양귀비속 @양비귀과 @미나리아재비목 @진정쌍자엽식물강 @피자식물문 @6 @7 @white @gress @hair @moyeo @ellipse @non @green @sharp @sharp " +
                "#@애기장대 @Arabidopsis thaliana Heynh. @애기장대속 @배추과 @십자화목 @진정쌍자엽식물강 @피자식물문 @4 @5 @white @gress @no @moyeo @ellipse @non @green @sharp @flat " +
                "#@기린초 @Phedimus kamtschaticus (Fisch. & C.A.Mey.) E.'t Hart @기린초속 @돌나물과 @돌나물목 @진정쌍자엽식물강 @피자식물문 @6 @8 @yellow @gress @straight @maju @ellipse @non @green @smooth @round " +
                "#@산수국 @Hydrangea macrophylla Ser. subsp. serrata Makino @수국속 @수국과 @층층나무목 @진정쌍자엽식물강 @피자식물문 @7 @8 @purple @gress @hair @maju @ellipse @non @green @sharp @sharp " +
                "#@가시까치밥나무 @Ribes diacanthum Pall. @뱀딸기속 @장미과 @범의귀목 @진정쌍자엽식물강 @피자식물문 @6 @8 @yellow @wood @thron @auget @ellipse @non @red @sharp @round " +
                "#@뱀딸기 @Duchesnea indica Teschem. @뱀딸기속 @장미과 @장미목 @진정쌍자엽식물강 @피자식물문 @4 @5 @yellow @gress @hair @auget @round @non @red @wave @round " +
                "#@양지꽃 @Potentilla fragarioides L. var. major Maxim. @양지꽃속 @장미과 @장미목 @진정쌍자엽식물강 @피자식물문 @4 @6 @yellow @gress @hair @non @ellipse @non @green @sharp @sharp " +
                "#@찔레꽃 @Rosa multiflora Thunb. @장미속 @장미과 @장미목 @진정쌍자엽식물강 @피자식물문 @6 @10 @white @wood @thron @maju @fan @non @brown @sharp @sharp " +
                "#@산딸기 @Rubus crataegifolius Bunge @산딸기속 @장미과 @장미목 @진정쌍자엽식물강 @피자식물문 @5 @6 @white @gress @hair @meyeo @fan @non @red @smooth @sharp " +
                "#@오이풀 @Sanguisorba officinalis L. @오이풀속 @장미과 @장미목 @진정쌍자엽식물강 @피자식물문 @7 @9 @red @gress @straight @auget @ellipse @parallel @green @smooth @sharp " +
                "#@조팝나무 @Spiraea prunifolia Siebold & Zucc. f. simpliciflora Nakai @조팝나무속 @장미과 @장미목 @진정쌍자엽식물강 @피자식물문 @4 @5 @white @wood @straight @auget @ellipse @non @green @sharp @sharp " +
                "#@조록싸리 @Lespedeza maximowiczii C.K.Schneid. @싸리속 @콩과 @콩목 @진정쌍자엽식물강 @피자식물문 @6 @7 @purple @wood @straight @non @ellipse @non @brown @smooth @sharp " +
                "#@칡 @Pueraria lobata Ohwi @콩과 @칡속 @쥐방울덩굴과 @후추목 @피자식물문 @8 @8 @red @wood @vine @non @ellipse @non @brown @smooth @round " +
                "#@애기풀 @Polygala japonica Houtt. @원지속 @원지과 @콩목 @진정쌍자엽식물강 @피자식물문 @4 @5 @orange @gress @hair @auget @ellipse @non @green @smooth @round " +
                "#@망개나무 @Berchemia berchemiifolia (Makino) Koidz. @망개나무속 @갈매나무과 @장미목 @진정쌍자엽식물강 @피자식물문 @6 @6 @green @wood @straight @auget @ellipse @non @red @smooth @sharp " +
                "#@헛개나무 @Hovenia dulcis Thunb. @헛개나무속 @갈매나무과 @장미목 @진정쌍자엽식물강 @피자식물문 @7 @7 @green @wood @straight @auget @ellipse @non @sharp @wave @sharp " +
                "#@담쟁이덩굴 @Parthenocissus tricuspidata (Siebold & Zucc.) Planch. @담쟁이덩굴속 @포도과 @포도목 @진정쌍자엽식물강 @피자식물문 @6 @7 @green @gress @vine @auget @ellipse @non @black @sharp @sharp " +
                "#@까치깨 @Corchoropsis tomentosa @까치깨속 @피나무과 @아욱목 @진정쌍자엽식물강 @피자식물문 @6 @8 @yellow @gress @hair @auget @ellipse @non @green @wave @sharp " +
                "#@제비꽃 @Viola mandshurica W.Becker @제비꽃속 @제비꽃과 @꿀풀목 @진정쌍자엽식물강 @피자식물문 @4 @5 @purple @gress @non @moyeo @ellipse @non @green @shrap @round " +
                "#@개구릿대 @Angelica anomala Avé-Lall. @당귀속 @산형과 @미나리목 @진정쌍자엽식물강 @피자식물문 @7 @8 @white @gress @straight @non @ellipse @non @green @sharp @sharp " ;

        String plantCharacter2 ="#@갈퀴덩굴 @Galium spurium L. var. echinospermum (Wallr.) Desp. @갈귀덩굴속 @꼭두서니과 @용담목 @진정쌍자엽식물강 @피자식물문 @5 @6 @green @gress @thron @dol @neddle @non @green @smooth @sharp " +
                "#@솔나물 @Galium verum L. subsp. asiaticum (Nakai) T.Yamaz. @갈귀덩굴속 @꼭두서니과 @용담목 @진정쌍자엽식물강 @피자식물문 @6 @8 @yellow @gress @hair @dol @sharp @non @green @smooth @sharp " +
                "#@송양나무 @Ehretia acuminata R.Br. @송양나무속 @지치과 @지치목 @진정쌍자엽식물강 @피자식물문 @6 @7 @white @wood @straight @auget @ellipse @non @yellow @sharp @tail " +
                "#@작살나무 @Callicarpa japonica Thunb. @작살나무속 @마편초과 @꿀풀목 @진정쌍자엽식물강 @피자식물문 @8 @8 @purple @wood @straight @maju @ellipse @non @purple @sharp @tail " +
                "#@도라지 @Platycodon grandiflorus A.DC. @도라지속 @초롱꽃과 @국화목 @진정쌍자엽식물강 @피자식물문 @7 @8 @blue @gress @straight @maju @sharp @non @green @smooth @sharp " +
                "#@닭의장풀 @Commelina communis L. @닭의장풀속 @닭의장풀과 @닭의장풀목 @진정쌍자엽식물강 @피자식물문 @7 @8 @blue @gress @straight @auget @ellipse @non @green @smooth @sharp " +
                "#@전나무 @Abies holophylla Maxim. @전나무속 @소나무과 @소나무목 @소나무목 @나자식물문 @4 @10 @yellow @wood @straight @non @needle @non @yellow @smooth @sharp " +
                "#@잣나무 @Pinus koraiensis Siebold & Zucc. @소나무속 @소나무과 @소나무목 @진정쌍자엽식물강 @피자식물문 @5 @10 @red @wood @straight @non @needle @non @red @smooth @sharp " +
                "#@느티나무 @Zelkova serrata Makino @느티나무속 @느티나무과 @장미목 @진정쌍자엽식물강 @피자식물문 @4 @5 @yellow @wood @hair @auget @ellipse @non @green @smooth @sharp " +
                "#@소나무 @PinusdensifloraSiebold @소나무속 @소나무과 @소나무목 @나자식물강 @나자식물문 @5 @5 @brown @wood @non @non @needle @non @brown @smooth @sharp " +
                "#@포도 @VitisviniferaL. @포도속 @포도과 @포도목 @진정쌍자엽식물강 @피자식물문  @6 @6 @green @wood @vine @auget @round @non @purple @sharp @sharp " +
                "#@목향장미 @RosabanksiaeAiton @장미속 @장미과 @장미목 @진정쌍자엽식물강 @피자식물문  @6 @8 @red @wood @thron @auget @round @non @non @sharp @sharp " +
                "#@민들레 @HelianthusannuusL. @구절초속 @국화과 @국화목 @진정쌍자엽식물강 @피자식물문  @6 @6 @yellow @gress @non @non @round @non @white @sharp @sharp " +
                "#@해바라기 @Helianthusannuus @해바라기속 @국화과 @국화목 @진정쌍자엽식물강 @피자식물문  @8 @8 @yellow @gress @hair @auget @round @non @gray @sharp @sharp " +
                "#@강아지풀 @SetariaviridisL. @대청가시풀속 @벼과 @벼목 @단자엽식물강 @피자식물문  @7 @7 @green @gress @non @yupcho @non @non @green @smooth @sharp " +
                "#@은행나무 @Ginkgobiloba @은행나무속 @은행나무과 @은행나무목 @나자식물강 @나자식물문 @5 @5 @green @wood @non @auget @fan @non @yellow @smooth @sharp " +
                "#@개나리 @Forsythiakoreana @개나리속 @물푸레나무과 @용담목 @진정쌍자엽식물강 @피자식물문 @4 @4 @yellow @gress @non @maju @round @non @green @sharp @sharp " +
                "#@무궁화 @HibiscussyriacusL. @무궁화속 @아욱과 @아욱목 @진정쌍자엽식물강 @피자식물문 @8 @8 @purple @wood @non @auget @round @non @yellow @sharp @sharp " +
                "#@국화 @DendranthemamorifoliumRamat.Tzvelev @구절초속 @국화과 @미나리아재비목 @진정쌍자엽식물강 @피자식물문 @9 @9 @white @gress @non @auget @round @non @non @sharp @sharp ";



        StringTokenizer lineToken = new StringTokenizer(plantCharacter,"#");
        String pLine;
        for(int t =0; t<20;t++) {
            pLine = lineToken.nextToken();
            StringTokenizer charToken = new StringTokenizer(pLine, "@");
            String plantchar[] = new String[MAX_SIZE_PLANT_CHARACTER];
            for (int q=0;q<MAX_SIZE_PLANT_CHARACTER;q++){
                plantchar[q] = charToken.nextToken();
            }
            plantDB[t] = new PlntData(plantchar[0],plantchar[1],plantchar[2],plantchar[3],plantchar[4],plantchar[5],plantchar[6],plantchar[7],plantchar[8],plantchar[9],plantchar[10],plantchar[11],plantchar[12],plantchar[13],plantchar[14],plantchar[15],plantchar[16],plantchar[17]);

        }
        StringTokenizer lineToken2 = new StringTokenizer(plantCharacter2,"#");
        for(int t =20; lineToken2.hasMoreTokens();t++) {
            pLine = lineToken2.nextToken();
            StringTokenizer charToken = new StringTokenizer(pLine, "@");
            String plantchar[] = new String[MAX_SIZE_PLANT_CHARACTER];
            for (int q=0;q<MAX_SIZE_PLANT_CHARACTER;q++){
                plantchar[q] = charToken.nextToken();
            }
            plantDB[t] = new PlntData(plantchar[0],plantchar[1],plantchar[2],plantchar[3],plantchar[4],plantchar[5],plantchar[6],plantchar[7],plantchar[8],plantchar[9],plantchar[10],plantchar[11],plantchar[12],plantchar[13],plantchar[14],plantchar[15],plantchar[16],plantchar[17]);

        }

    }
}