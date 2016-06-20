
package dqr.dataTable;

import dqr.api.enums.EnumDqmPet;
import dqr.entity.petEntity.DqmPetBase;

public class FuncExpTable
{
    public FuncExpTable()
    {
    }

    public int getNextExp(int Lv)
    {
        int retExp = 0;

        retExp = getNextExpFromTable(Lv);

        return retExp;
    }

    public int getNeedExp(int Lv)
    {
        int retExp = 0;

        retExp = getNeedExpFromTable(Lv);

        return retExp;
    }

    public int getJukurenNextExp(int Lv)
    {
    	int ret = 0;
    	switch(Lv)
    	{
    		case 0: ret = 50; break;
    		case 1: ret = 140; break;
    		case 2: ret = 350; break;
    		case 3: ret = 800; break;
    		case 4: ret = 1600; break;
    		case 5: ret = 3000; break;
    		case 6: ret = 5500; break;
    		case 7: ret = 11000; break;
    		case 8: ret = 24000; break;
    		case 9: ret = 50000; break;
    		case 10: ret = -1; break;
    		default : ret = 0; break;
    	}

    	return ret;
    }

    public int getJukurenNeedExp(int Lv)
    {
    	int ret = 0;
    	switch(Lv)
    	{
    		case 0: ret = 50; break;
    		case 1: ret = 90; break;
    		case 2: ret = 110; break;
    		case 3: ret = 450; break;
    		case 4: ret = 800; break;
    		case 5: ret = 1400; break;
    		case 6: ret = 2500; break;
    		case 7: ret = 5500; break;
    		case 8: ret = 13000; break;
    		case 9: ret = 26000; break;
    		case 10: ret = -1; break;
    		default : ret = 0; break;
    	}

    	return ret;
    }


    public int getNextExpPet(int Lv, DqmPetBase mob)
    {
        int retExp = 0;
        int fixLv = 0;

        EnumDqmPet petType = mob.type;
        fixLv = Lv + (99 - petType.MaxLv);

        retExp = getNextExpFromTable(fixLv) - getNextExpFromTable(99 - petType.MaxLv - 1);

        return retExp;
    }

    /*
    public int getNextExpPet2(int Lv, DqmPetBase mob)
    {
        int retExp = 0;
        int fixLv = 0;

        //System.out.println("TEST" + fixLv + " / " + retExp);

        EnumDqmPet petType = mob.type;
        fixLv = Lv + (99 - petType.MaxLv);

        retExp = getNextExpFromTable(fixLv);

        return retExp;
    }
    */

    public int getNeedExpPet(int Lv, DqmPetBase mob)
    {
        int retExp = 0;

        EnumDqmPet petType = mob.type;
        int fixLv = Lv + (99 - petType.MaxLv);

        retExp = getNeedExpFromTable(fixLv) - getNeedExpFromTable(99 - petType.MaxLv - 1);

        return retExp;
    }

    public int getNeedExpFromTable(int par1)
    {
    	int retExp = 0;

        switch (par1)
        {
            case 0:
                retExp = 7;
                break;

            case 1:
                retExp = 15;
                break;

            case 2:
                retExp = 26;
                break;

            case 3:
                retExp = 40;
                break;

            case 4:
                retExp = 59;
                break;

            case 5:
                retExp = 87;
                break;

            case 6:
                retExp = 128;
                break;

            case 7:
                retExp = 184;
                break;

            case 8:
                retExp = 264;
                break;

            case 9:
                retExp = 370;
                break;

            case 10:
                retExp = 512;
                break;

            case 11:
                retExp = 691;
                break;

            case 12:
                retExp = 920;
                break;

            case 13:
                retExp = 1200;
                break;

            case 14:
                retExp = 1540;
                break;

            case 15:
                retExp = 1946;
                break;

            case 16:
                retExp = 2423;
                break;

            case 17:
                retExp = 2975;
                break;

            case 18:
                retExp = 3609;
                break;

            case 19:
                retExp = 4324;
                break;

            case 20:
                retExp = 5127;
                break;

            case 21:
                retExp = 6012;
                break;

            case 22:
                retExp = 6985;
                break;

            case 23:
                retExp = 8036;
                break;

            case 24:
                retExp = 9165;
                break;

            case 25:
                retExp = 10364;
                break;

            case 26:
                retExp = 11629;
                break;

            case 27:
                retExp = 12961;
                break;

            case 28:
                retExp = 14359;
                break;

            case 29:
                retExp = 15826;
                break;

            case 30:
                retExp = 17362;
                break;

            case 31:
                retExp = 18969;
                break;

            case 32:
                retExp = 20650;
                break;

            case 33:
                retExp = 22404;
                break;

            case 34:
                retExp = 24232;
                break;

            case 35:
                retExp = 26136;
                break;

            case 36:
                retExp = 28118;
                break;

            case 37:
                retExp = 30180;
                break;

            case 38:
                retExp = 32319;
                break;

            case 39:
                retExp = 34541;
                break;

            case 40:
                retExp = 36844;
                break;

            case 41:
                retExp = 39231;
                break;

            case 42:
                retExp = 41704;
                break;

            case 43:
                retExp = 44262;
                break;

            case 44:
                retExp = 46907;
                break;

            case 45:
                retExp = 49641;
                break;

            case 46:
                retExp = 52464;
                break;

            case 47:
                retExp = 55381;
                break;

            case 48:
                retExp = 58387;
                break;

            case 49:
                retExp = 61488;
                break;

            case 50:
                retExp = 67917;
                break;

            case 51:
                retExp = 71537;
                break;

            case 52:
                retExp = 75271;
                break;

            case 53:
                retExp = 79117;
                break;

            case 54:
                retExp = 83073;
                break;

            case 55:
                retExp = 87137;
                break;

            case 56:
                retExp = 91308;
                break;

            case 57:
                retExp = 95585;
                break;

            case 58:
                retExp = 99971;
                break;

            case 59:
                retExp = 104464;
                break;

            case 60:
                retExp = 109062;
                break;

            case 61:
                retExp = 113764;
                break;

            case 62:
                retExp = 118569;
                break;

            case 63:
                retExp = 123479;
                break;

            case 64:
                retExp = 128492;
                break;

            case 65:
                retExp = 133606;
                break;

            case 66:
                retExp = 138820;
                break;

            case 67:
                retExp = 144133;
                break;

            case 68:
                retExp = 149547;
                break;

            case 69:
                retExp = 149547;
                break;

            case 70:
                retExp = 10401;
                break;

            case 71:
                retExp = 170274;
                break;

            case 72:
                retExp = 180600;
                break;

            case 73:
                retExp = 190926;
                break;

            case 74:
                retExp = 201252;
                break;

            case 75:
                retExp = 211578;
                break;

            case 76:
                retExp = 221904;
                break;

            case 77:
                retExp = 232230;
                break;

            case 78:
                retExp = 242556;
                break;

            case 79:
                retExp = 252882;
                break;

            case 80:
                retExp = 263208;
                break;

            case 81:
                retExp = 273534;
                break;

            case 82:
                retExp = 283860;
                break;

            case 83:
                retExp = 294186;
                break;

            case 84:
                retExp = 304512;
                break;

            case 85:
                retExp = 314838;
                break;

            case 86:
                retExp = 325164;
                break;

            case 87:
                retExp = 335490;
                break;

            case 88:
                retExp = 345816;
                break;

            case 89:
                retExp = 356142;
                break;

            case 90:
                retExp = 366468;
                break;

            case 91:
                retExp = 376794;
                break;

            case 92:
                retExp = 387120;
                break;

            case 93:
                retExp = 397446;
                break;

            case 94:
                retExp = 407772;
                break;

            case 95:
                retExp = 418098;
                break;

            case 96:
                retExp = 428424;
                break;

            case 97:
                retExp = 438750;
                break;

            case 98:
                retExp = 449076;
                break;

            case 99:
                retExp = 0;
                break;

            default :
                retExp = 0;
        }

    	return retExp;
    }
    public int getNextExpFromTable(int par1)
    {
    	int retExp = 0;

        switch (par1)
        {
            case 0:
                retExp = 7;
                break;

            case 1:
                retExp = 22;
                break;

            case 2:
                retExp = 48;
                break;

            case 3:
                retExp = 88;
                break;

            case 4:
                retExp = 147;
                break;

            case 5:
                retExp = 234;
                break;

            case 6:
                retExp = 362;
                break;

            case 7:
                retExp = 546;
                break;

            case 8:
                retExp = 810;
                break;

            case 9:
                retExp = 1180;
                break;

            case 10:
                retExp = 1692;
                break;

            case 11:
                retExp = 2383;
                break;

            case 12:
                retExp = 3303;
                break;

            case 13:
                retExp = 4503;
                break;

            case 14:
                retExp = 6043;
                break;

            case 15:
                retExp = 7989;
                break;

            case 16:
                retExp = 10412;
                break;

            case 17:
                retExp = 13387;
                break;

            case 18:
                retExp = 16996;
                break;

            case 19:
                retExp = 21320;
                break;

            case 20:
                retExp = 26447;
                break;

            case 21:
                retExp = 32459;
                break;

            case 22:
                retExp = 39444;
                break;

            case 23:
                retExp = 47480;
                break;

            case 24:
                retExp = 56645;
                break;

            case 25:
                retExp = 67009;
                break;

            case 26:
                retExp = 78638;
                break;

            case 27:
                retExp = 91599;
                break;

            case 28:
                retExp = 105958;
                break;

            case 29:
                retExp = 121784;
                break;

            case 30:
                retExp = 139146;
                break;

            case 31:
                retExp = 158115;
                break;

            case 32:
                retExp = 178765;
                break;

            case 33:
                retExp = 201169;
                break;

            case 34:
                retExp = 225401;
                break;

            case 35:
                retExp = 251537;
                break;

            case 36:
                retExp = 279655;
                break;

            case 37:
                retExp = 309835;
                break;

            case 38:
                retExp = 342154;
                break;

            case 39:
                retExp = 376695;
                break;

            case 40:
                retExp = 413539;
                break;

            case 41:
                retExp = 452770;
                break;

            case 42:
                retExp = 494474;
                break;

            case 43:
                retExp = 538736;
                break;

            case 44:
                retExp = 585643;
                break;

            case 45:
                retExp = 635284;
                break;

            case 46:
                retExp = 687748;
                break;

            case 47:
                retExp = 743129;
                break;

            case 48:
                retExp = 801516;
                break;

            case 49:
                retExp = 863004;
                break;

            case 50:
                retExp = 930921;
                break;

            case 51:
                retExp = 1002458;
                break;

            case 52:
                retExp = 1077729;
                break;

            case 53:
                retExp = 1156846;
                break;

            case 54:
                retExp = 1239919;
                break;

            case 55:
                retExp = 1327056;
                break;

            case 56:
                retExp = 1418364;
                break;

            case 57:
                retExp = 1513949;
                break;

            case 58:
                retExp = 1613920;
                break;

            case 59:
                retExp = 1718384;
                break;

            case 60:
                retExp = 1827446;
                break;

            case 61:
                retExp = 1941210;
                break;

            case 62:
                retExp = 2059779;
                break;

            case 63:
                retExp = 2183258;
                break;

            case 64:
                retExp = 2311750;
                break;

            case 65:
                retExp = 2445356;
                break;

            case 66:
                retExp = 2584176;
                break;

            case 67:
                retExp = 2728309;
                break;

            case 68:
                retExp = 2877856;
                break;

            case 69:
                retExp = 3027403;
                break;

            case 70:
                retExp = 3037804;
                break;

            case 71:
                retExp = 3208078;
                break;

            case 72:
                retExp = 3388678;
                break;

            case 73:
                retExp = 3579604;
                break;

            case 74:
                retExp = 3780856;
                break;

            case 75:
                retExp = 3992434;
                break;

            case 76:
                retExp = 4214338;
                break;

            case 77:
                retExp = 4446568;
                break;

            case 78:
                retExp = 4689124;
                break;

            case 79:
                retExp = 4942006;
                break;

            case 80:
                retExp = 5205214;
                break;

            case 81:
                retExp = 5478748;
                break;

            case 82:
                retExp = 5762608;
                break;

            case 83:
                retExp = 6056794;
                break;

            case 84:
                retExp = 6361306;
                break;

            case 85:
                retExp = 6676144;
                break;

            case 86:
                retExp = 7001308;
                break;

            case 87:
                retExp = 7336798;
                break;

            case 88:
                retExp = 7682614;
                break;

            case 89:
                retExp = 8038756;
                break;

            case 90:
                retExp = 8405224;
                break;

            case 91:
                retExp = 8782018;
                break;

            case 92:
                retExp = 9169138;
                break;

            case 93:
                retExp = 9566584;
                break;

            case 94:
                retExp = 9974356;
                break;

            case 95:
                retExp = 10392454;
                break;

            case 96:
                retExp = 10820878;
                break;

            case 97:
                retExp = 11259628;
                break;

            case 98:
                retExp = 11708704;
                break;

            case 99:
                retExp = 0;
                break;

            default :
                retExp = 0;
        }

    	return retExp;
    }
}
