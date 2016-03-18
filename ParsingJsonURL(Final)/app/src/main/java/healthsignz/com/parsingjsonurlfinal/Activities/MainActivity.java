package healthsignz.com.parsingjsonurlfinal.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import healthsignz.com.parsingjsonurlfinal.Adapter.ContactListAdapter;
import healthsignz.com.parsingjsonurlfinal.AsyncClasses.FetchData;
import healthsignz.com.parsingjsonurlfinal.Beans.ContactInfo;
import healthsignz.com.parsingjsonurlfinal.Interfaces.Commincator;
import healthsignz.com.parsingjsonurlfinal.R;

public class MainActivity extends AppCompatActivity implements Commincator{
  // String json ="";
    String jsonURL ;
    String json = "[{\"contactId\":1,\"name\":\"Nicole\",\"landNo\":4907432137,\"mobileNo\":73487747566,\"remark\":\"Ruth\",\"city\":\"Penny\",\"emailId\":\"kim@nichols.sx\"},{\"contactId\":2,\"name\":\"Stephen\",\"landNo\":75988225873,\"mobileNo\":40606896563,\"remark\":\"Ben\",\"city\":\"Samantha\",\"emailId\":\"helen@kelley.ru\"},{\"contactId\":3,\"name\":\"Jeff\",\"landNo\":8448747594,\"mobileNo\":84940226141,\"remark\":\"Wesley\",\"city\":\"Joshua\",\"emailId\":\"curtis@baxter.br\"},{\"contactId\":4,\"name\":\"Jesse\",\"landNo\":43918781258,\"mobileNo\":29086514050,\"remark\":\"Randy\",\"city\":\"Sherri\",\"emailId\":\"douglas@middleton.mo\"},{\"contactId\":5,\"name\":\"Erin\",\"landNo\":68777926891,\"mobileNo\":61342190111,\"remark\":\"Audrey\",\"city\":\"Kristin\",\"emailId\":\"rick@love.fo\"},{\"contactId\":6,\"name\":\"Teresa\",\"landNo\":37000801206,\"mobileNo\":58003427082,\"remark\":\"Carl\",\"city\":\"Virginia\",\"emailId\":\"marc@kramer.pt\"},{\"contactId\":7,\"name\":\"Hugh\",\"landNo\":65406302879,\"mobileNo\":11187295794,\"remark\":\"Keith\",\"city\":\"Evelyn\",\"emailId\":\"rita@bowman.gov\"},{\"contactId\":8,\"name\":\"Norman\",\"landNo\":53987627965,\"mobileNo\":3522522049,\"remark\":\"Kim\",\"city\":\"Jordan\",\"emailId\":\"linda@o.af\"},{\"contactId\":9,\"name\":\"Penny\",\"landNo\":40244509818,\"mobileNo\":63128354002,\"remark\":\"Jay\",\"city\":\"Ben\",\"emailId\":\"norman@hamrick.pf\"},{\"contactId\":10,\"name\":\"Jonathan\",\"landNo\":49591041238,\"mobileNo\":54066037488,\"remark\":\"Eileen\",\"city\":\"George\",\"emailId\":\"edwin@schultz.cw\"},{\"contactId\":11,\"name\":\"Natalie\",\"landNo\":42516521410,\"mobileNo\":41430775480,\"remark\":\"Francis\",\"city\":\"Eddie\",\"emailId\":\"jerry@monroe.ie\"},{\"contactId\":12,\"name\":\"Leroy\",\"landNo\":48075008666,\"mobileNo\":32814617534,\"remark\":\"Eileen\",\"city\":\"Kristina\",\"emailId\":\"helen@carey.bf\"},{\"contactId\":13,\"name\":\"Lawrence\",\"landNo\":78118287502,\"mobileNo\":61655381500,\"remark\":\"Michele\",\"city\":\"Constance\",\"emailId\":\"carlos@james.pn\"},{\"contactId\":14,\"name\":\"Jeff\",\"landNo\":29164891858,\"mobileNo\":23892345322,\"remark\":\"Sean\",\"city\":\"Becky\",\"emailId\":\"leslie@sanchez.br\"},{\"contactId\":15,\"name\":\"Johnny\",\"landNo\":33491522259,\"mobileNo\":25294000842,\"remark\":\"Eddie\",\"city\":\"Penny\",\"emailId\":\"ruth@hoyle.tj\"},{\"contactId\":16,\"name\":\"Geraldine\",\"landNo\":85434265799,\"mobileNo\":71363165264,\"remark\":\"Jose\",\"city\":\"Jerry\",\"emailId\":\"kenneth@hayes.kz\"},{\"contactId\":17,\"name\":\"Jamie\",\"landNo\":83932359619,\"mobileNo\":76926744483,\"remark\":\"Martin\",\"city\":\"Lloyd\",\"emailId\":\"jeff@hirsch.sl\"},{\"contactId\":18,\"name\":\"Wesley\",\"landNo\":27876767882,\"mobileNo\":51661700535,\"remark\":\"Bradley\",\"city\":\"Lucille\",\"emailId\":\"toni@cannon.bj\"},{\"contactId\":19,\"name\":\"Randall\",\"landNo\":55214596068,\"mobileNo\":77610829054,\"remark\":\"Annie\",\"city\":\"Stephen\",\"emailId\":\"jessica@townsend.bf\"},{\"contactId\":20,\"name\":\"Natalie\",\"landNo\":20482722839,\"mobileNo\":14386418960,\"remark\":\"Marlene\",\"city\":\"Dana\",\"emailId\":\"erin@pickett.it\"},{\"contactId\":21,\"name\":\"Russell\",\"landNo\":60105761181,\"mobileNo\":15137402597,\"remark\":\"Gretchen\",\"city\":\"Marshall\",\"emailId\":\"lewis@byers.dz\"},{\"contactId\":22,\"name\":\"Julia\",\"landNo\":38279124915,\"mobileNo\":40483358314,\"remark\":\"Jeanette\",\"city\":\"Franklin\",\"emailId\":\"leon@berger.jo\"},{\"contactId\":23,\"name\":\"Danielle\",\"landNo\":45621407392,\"mobileNo\":35234354484,\"remark\":\"Diana\",\"city\":\"Jeanette\",\"emailId\":\"andrew@gallagher.edu\"},{\"contactId\":24,\"name\":\"Samantha\",\"landNo\":29713348107,\"mobileNo\":5186075406,\"remark\":\"Melissa\",\"city\":\"Janet\",\"emailId\":\"glen@hoover.bj\"},{\"contactId\":25,\"name\":\"Gilbert\",\"landNo\":18494135292,\"mobileNo\":59563003523,\"remark\":\"Emily\",\"city\":\"Terry\",\"emailId\":\"pat@bolton.na\"},{\"contactId\":26,\"name\":\"Guy\",\"landNo\":5881668612,\"mobileNo\":46498960086,\"remark\":\"Lawrence\",\"city\":\"Gloria\",\"emailId\":\"rhonda@haynes.mt\"},{\"contactId\":27,\"name\":\"Elisabeth\",\"landNo\":58809108844,\"mobileNo\":60560957387,\"remark\":\"Kathy\",\"city\":\"Tamara\",\"emailId\":\"toni@clements.cd\"},{\"contactId\":28,\"name\":\"Denise\",\"landNo\":1326568555,\"mobileNo\":59995075254,\"remark\":\"Miriam\",\"city\":\"Marian\",\"emailId\":\"nicole@wallace.td\"},{\"contactId\":29,\"name\":\"Tommy\",\"landNo\":59496823986,\"mobileNo\":38376312889,\"remark\":\"Harold\",\"city\":\"Stephanie\",\"emailId\":\"keith@bray.lr\"},{\"contactId\":30,\"name\":\"Wendy\",\"landNo\":88699665758,\"mobileNo\":20202377557,\"remark\":\"Gina\",\"city\":\"Elsie\",\"emailId\":\"troy@livingston.mz\"},{\"contactId\":31,\"name\":\"Ethel\",\"landNo\":40139697453,\"mobileNo\":24271580194,\"remark\":\"Lucy\",\"city\":\"Courtney\",\"emailId\":\"louise@stephens.mh\"},{\"contactId\":32,\"name\":\"Glenda\",\"landNo\":31384680579,\"mobileNo\":55697076878,\"remark\":\"Marian\",\"city\":\"Chris\",\"emailId\":\"peter@waters.tf\"},{\"contactId\":33,\"name\":\"Scott\",\"landNo\":86620155810,\"mobileNo\":71637819107,\"remark\":\"Gina\",\"city\":\"Todd\",\"emailId\":\"johnny@houston.sy\"},{\"contactId\":34,\"name\":\"Natalie\",\"landNo\":84506207413,\"mobileNo\":61447334828,\"remark\":\"Gladys\",\"city\":\"Arthur\",\"emailId\":\"bill@song.gg\"},{\"contactId\":35,\"name\":\"Sheryl\",\"landNo\":40205685569,\"mobileNo\":38902404189,\"remark\":\"Ronnie\",\"city\":\"Ashley\",\"emailId\":\"melinda@dunlap.io\"},{\"contactId\":36,\"name\":\"Lynne\",\"landNo\":68056863538,\"mobileNo\":89393889791,\"remark\":\"Jason\",\"city\":\"Michelle\",\"emailId\":\"louise@riddle.co\"},{\"contactId\":37,\"name\":\"Tracy\",\"landNo\":21395225118,\"mobileNo\":77103852731,\"remark\":\"Jennifer\",\"city\":\"Don\",\"emailId\":\"zachary@kramer.gd\"},{\"contactId\":38,\"name\":\"Gretchen\",\"landNo\":9504888850,\"mobileNo\":60688977145,\"remark\":\"Deborah\",\"city\":\"Greg\",\"emailId\":\"mary@pugh.kz\"},{\"contactId\":39,\"name\":\"Kristina\",\"landNo\":51837925409,\"mobileNo\":9897475662,\"remark\":\"Maureen\",\"city\":\"Jim\",\"emailId\":\"megan@erickson.ge\"},{\"contactId\":40,\"name\":\"Jerome\",\"landNo\":6769500777,\"mobileNo\":16909854596,\"remark\":\"Holly\",\"city\":\"Nicole\",\"emailId\":\"audrey@nash.nr\"},{\"contactId\":41,\"name\":\"Hugh\",\"landNo\":38170410744,\"mobileNo\":78478204953,\"remark\":\"Jamie\",\"city\":\"Gayle\",\"emailId\":\"anna@lindsay.sg\"},{\"contactId\":42,\"name\":\"Heidi\",\"landNo\":58068415478,\"mobileNo\":24810294942,\"remark\":\"Randall\",\"city\":\"Ricky\",\"emailId\":\"clifford@walton.nc\"},{\"contactId\":43,\"name\":\"Melissa\",\"landNo\":76904381353,\"mobileNo\":51402415005,\"remark\":\"Carl\",\"city\":\"Brenda\",\"emailId\":\"joanna@caldwell.ke\"},{\"contactId\":44,\"name\":\"Toni\",\"landNo\":23709470592,\"mobileNo\":6276543191,\"remark\":\"Henry\",\"city\":\"Christina\",\"emailId\":\"marianne@barrett.us\"},{\"contactId\":45,\"name\":\"Steven\",\"landNo\":56281624492,\"mobileNo\":75907229617,\"remark\":\"Marcia\",\"city\":\"Theodore\",\"emailId\":\"sandy@stanley.sr\"},{\"contactId\":46,\"name\":\"Sarah\",\"landNo\":79731755724,\"mobileNo\":10062794511,\"remark\":\"Dean\",\"city\":\"Thomas\",\"emailId\":\"melinda@whitaker.gi\"},{\"contactId\":47,\"name\":\"Sandra\",\"landNo\":36719492311,\"mobileNo\":67848604490,\"remark\":\"Joann\",\"city\":\"Kristen\",\"emailId\":\"curtis@allen.iq\"},{\"contactId\":48,\"name\":\"Lester\",\"landNo\":940283526,\"mobileNo\":71558040785,\"remark\":\"Danielle\",\"city\":\"Vickie\",\"emailId\":\"annie@lindsay.sv\"},{\"contactId\":49,\"name\":\"Gayle\",\"landNo\":67016858751,\"mobileNo\":13572678383,\"remark\":\"Peter\",\"city\":\"Joanna\",\"emailId\":\"regina@kemp.mm\"},{\"contactId\":50,\"name\":\"Edna\",\"landNo\":31689411863,\"mobileNo\":61273052225,\"remark\":\"Craig\",\"city\":\"Geraldine\",\"emailId\":\"carole@johnson.sc\"},{\"contactId\":51,\"name\":\"Wesley\",\"landNo\":29351567386,\"mobileNo\":88533991246,\"remark\":\"Catherine\",\"city\":\"Wayne\",\"emailId\":\"christopher@lamb.es\"},{\"contactId\":52,\"name\":\"Franklin\",\"landNo\":65934409775,\"mobileNo\":12825043063,\"remark\":\"Chris\",\"city\":\"Robin\",\"emailId\":\"karen@hewitt.gn\"},{\"contactId\":53,\"name\":\"Melissa\",\"landNo\":36368415490,\"mobileNo\":22507387883,\"remark\":\"Sandra\",\"city\":\"Brett\",\"emailId\":\"martin@richardson.ir\"},{\"contactId\":54,\"name\":\"Paige\",\"landNo\":89534067274,\"mobileNo\":24782289169,\"remark\":\"Leon\",\"city\":\"Renee\",\"emailId\":\"theodore@curry.mq\"},{\"contactId\":55,\"name\":\"Sidney\",\"landNo\":82309109997,\"mobileNo\":88992287236,\"remark\":\"Tracey\",\"city\":\"Harold\",\"emailId\":\"donna@bowling.ph\"},{\"contactId\":56,\"name\":\"Sarah\",\"landNo\":68757283683,\"mobileNo\":7987052812,\"remark\":\"Jacob\",\"city\":\"Amanda\",\"emailId\":\"jeff@coleman.org\"},{\"contactId\":57,\"name\":\"Dorothy\",\"landNo\":30867016443,\"mobileNo\":68981631218,\"remark\":\"Harold\",\"city\":\"Dorothy\",\"emailId\":\"dean@sharpe.gl\"},{\"contactId\":58,\"name\":\"Paige\",\"landNo\":67316244482,\"mobileNo\":41745665630,\"remark\":\"Malcolm\",\"city\":\"Peter\",\"emailId\":\"bob@stuart.it\"},{\"contactId\":59,\"name\":\"Marcia\",\"landNo\":85387227457,\"mobileNo\":84537081268,\"remark\":\"Marsha\",\"city\":\"Kristin\",\"emailId\":\"ashley@burton.mn\"},{\"contactId\":60,\"name\":\"Henry\",\"landNo\":85761560441,\"mobileNo\":52191606496,\"remark\":\"Randall\",\"city\":\"Bernice\",\"emailId\":\"philip@lam.ne\"},{\"contactId\":61,\"name\":\"Marlene\",\"landNo\":57171387240,\"mobileNo\":22868202031,\"remark\":\"Gladys\",\"city\":\"Lynn\",\"emailId\":\"julian@harrell.dk\"},{\"contactId\":62,\"name\":\"Hannah\",\"landNo\":67774717477,\"mobileNo\":89361899096,\"remark\":\"Lynn\",\"city\":\"Jennifer\",\"emailId\":\"katherine@mcdonald.ec\"},{\"contactId\":63,\"name\":\"Jeff\",\"landNo\":11640757704,\"mobileNo\":13663378159,\"remark\":\"Leroy\",\"city\":\"Jeanette\",\"emailId\":\"gayle@langley.tl (changed from tp)\"},{\"contactId\":64,\"name\":\"Herbert\",\"landNo\":8713199929,\"mobileNo\":23185326627,\"remark\":\"Gary\",\"city\":\"Don\",\"emailId\":\"jill@mckenna.dm\"},{\"contactId\":65,\"name\":\"Helen\",\"landNo\":2274984484,\"mobileNo\":18271986996,\"remark\":\"Betty\",\"city\":\"Nicholas\",\"emailId\":\"marlene@wagner.dj\"},{\"contactId\":66,\"name\":\"Clara\",\"landNo\":75568671446,\"mobileNo\":7908986226,\"remark\":\"Joyce\",\"city\":\"Sheryl\",\"emailId\":\"renee@hunt.mk\"},{\"contactId\":67,\"name\":\"Andrew\",\"landNo\":39954410531,\"mobileNo\":55980599168,\"remark\":\"Rebecca\",\"city\":\"Brooke\",\"emailId\":\"alvin@branch.gov\"},{\"contactId\":68,\"name\":\"Gwendolyn\",\"landNo\":69326806931,\"mobileNo\":52803394573,\"remark\":\"Diana\",\"city\":\"Claire\",\"emailId\":\"christian@elmore.jp\"},{\"contactId\":69,\"name\":\"Shannon\",\"landNo\":39645448499,\"mobileNo\":40406754139,\"remark\":\"Eileen\",\"city\":\"Janice\",\"emailId\":\"nina@mclean.mr\"},{\"contactId\":70,\"name\":\"Courtney\",\"landNo\":42791160828,\"mobileNo\":84526968809,\"remark\":\"Ashley\",\"city\":\"Lillian\",\"emailId\":\"louise@byrd.lu\"},{\"contactId\":71,\"name\":\"Geoffrey\",\"landNo\":1375027891,\"mobileNo\":75954825468,\"remark\":\"Randall\",\"city\":\"Judy\",\"emailId\":\"erin@davies.mc\"},{\"contactId\":72,\"name\":\"Florence\",\"landNo\":75704426887,\"mobileNo\":65273327330,\"remark\":\"Maria\",\"city\":\"Carl\",\"emailId\":\"wesley@berger.ao\"},{\"contactId\":73,\"name\":\"Frances\",\"landNo\":62463836975,\"mobileNo\":32306318950,\"remark\":\"Jon\",\"city\":\"Peggy\",\"emailId\":\"audrey@olson.bn\"},{\"contactId\":74,\"name\":\"Lori\",\"landNo\":70562455098,\"mobileNo\":83369744449,\"remark\":\"Gilbert\",\"city\":\"Ben\",\"emailId\":\"claire@montgomery.bn\"},{\"contactId\":75,\"name\":\"Sidney\",\"landNo\":53096398457,\"mobileNo\":10021581697,\"remark\":\"James\",\"city\":\"Gayle\",\"emailId\":\"marcus@sutherland.bv\"},{\"contactId\":76,\"name\":\"Jessica\",\"landNo\":52327107022,\"mobileNo\":35253091208,\"remark\":\"Sandy\",\"city\":\"James\",\"emailId\":\"willie@bowers.sz\"},{\"contactId\":77,\"name\":\"Dan\",\"landNo\":65756193779,\"mobileNo\":33010207378,\"remark\":\"Mary\",\"city\":\"Joel\",\"emailId\":\"joanne@bowers.sr\"},{\"contactId\":78,\"name\":\"Dean\",\"landNo\":61168836160,\"mobileNo\":63211664039,\"remark\":\"Diana\",\"city\":\"Sue\",\"emailId\":\"claire@garcia.dz\"},{\"contactId\":79,\"name\":\"Kim\",\"landNo\":72106809041,\"mobileNo\":29850890417,\"remark\":\"Claire\",\"city\":\"Dennis\",\"emailId\":\"natalie@pritchard.sh\"},{\"contactId\":80,\"name\":\"Peggy\",\"landNo\":70795243820,\"mobileNo\":14666350350,\"remark\":\"Victor\",\"city\":\"Margaret\",\"emailId\":\"rhonda@nguyen.ec\"},{\"contactId\":81,\"name\":\"Peggy\",\"landNo\":45714199951,\"mobileNo\":40605980198,\"remark\":\"Gladys\",\"city\":\"Tommy\",\"emailId\":\"mike@whitaker.sa\"},{\"contactId\":82,\"name\":\"Linda\",\"landNo\":37931238310,\"mobileNo\":75022476566,\"remark\":\"Monica\",\"city\":\"Christopher\",\"emailId\":\"amy@craig.jo\"},{\"contactId\":83,\"name\":\"Lori\",\"landNo\":8348035985,\"mobileNo\":25241342304,\"remark\":\"Toni\",\"city\":\"Hazel\",\"emailId\":\"nina@cassidy.eg\"},{\"contactId\":84,\"name\":\"Bob\",\"landNo\":35825838420,\"mobileNo\":66957350716,\"remark\":\"Kyle\",\"city\":\"Melanie\",\"emailId\":\"cheryl@gibson.fk\"},{\"contactId\":85,\"name\":\"Keith\",\"landNo\":77659291401,\"mobileNo\":13030823278,\"remark\":\"Patrick\",\"city\":\"Tom\",\"emailId\":\"jessica@weinstein.ga\"},{\"contactId\":86,\"name\":\"Carrie\",\"landNo\":5044737167,\"mobileNo\":30657680921,\"remark\":\"Frances\",\"city\":\"Gloria\",\"emailId\":\"claire@welch.sh\"},{\"contactId\":87,\"name\":\"Beth\",\"landNo\":26023079946,\"mobileNo\":82228151279,\"remark\":\"Bradley\",\"city\":\"Toni\",\"emailId\":\"hazel@savage.org\"},{\"contactId\":88,\"name\":\"Charlotte\",\"landNo\":89509854695,\"mobileNo\":80042977157,\"remark\":\"Barry\",\"city\":\"Warren\",\"emailId\":\"eddie@kirby.zm\"},{\"contactId\":89,\"name\":\"Jerome\",\"landNo\":77673862435,\"mobileNo\":81164872916,\"remark\":\"Joanne\",\"city\":\"Craig\",\"emailId\":\"clifford@vaughn.al\"},{\"contactId\":90,\"name\":\"Erin\",\"landNo\":28151227650,\"mobileNo\":84312881021,\"remark\":\"Gary\",\"city\":\"Alfred\",\"emailId\":\"kay@kelly.sd\"},{\"contactId\":91,\"name\":\"Jennifer\",\"landNo\":66532645821,\"mobileNo\":70933708593,\"remark\":\"Bonnie\",\"city\":\"Douglas\",\"emailId\":\"catherine@field.fr\"},{\"contactId\":92,\"name\":\"Gene\",\"landNo\":16166014538,\"mobileNo\":35108831790,\"remark\":\"Clara\",\"city\":\"Nelson\",\"emailId\":\"dorothy@chang.mx\"},{\"contactId\":93,\"name\":\"Dorothy\",\"landNo\":41267146905,\"mobileNo\":73560285327,\"remark\":\"Gary\",\"city\":\"Ronald\",\"emailId\":\"jeff@hardy.vc\"},{\"contactId\":94,\"name\":\"Neal\",\"landNo\":67088218525,\"mobileNo\":45876028082,\"remark\":\"Kim\",\"city\":\"Hazel\",\"emailId\":\"glenda@burnett.tc\"},{\"contactId\":95,\"name\":\"Jacob\",\"landNo\":21383343327,\"mobileNo\":8982526935,\"remark\":\"Jim\",\"city\":\"Evelyn\",\"emailId\":\"audrey@nguyen.org\"},{\"contactId\":96,\"name\":\"Lois\",\"landNo\":87775402232,\"mobileNo\":51280948303,\"remark\":\"Francis\",\"city\":\"Edwin\",\"emailId\":\"gayle@crews.tg\"},{\"contactId\":97,\"name\":\"Roy\",\"landNo\":2077086721,\"mobileNo\":2949442351,\"remark\":\"Maureen\",\"city\":\"Carolyn\",\"emailId\":\"judith@monroe.pa\"},{\"contactId\":98,\"name\":\"Holly\",\"landNo\":26072975592,\"mobileNo\":58882462490,\"remark\":\"Regina\",\"city\":\"Betty\",\"emailId\":\"mary@green.mp\"},{\"contactId\":99,\"name\":\"Lynn\",\"landNo\":76455263252,\"mobileNo\":34151823789,\"remark\":\"Clara\",\"city\":\"Julie\",\"emailId\":\"lester@barton.cu\"},{\"contactId\":100,\"name\":\"Jennifer\",\"landNo\":7146768952,\"mobileNo\":86447263658,\"remark\":\"Marian\",\"city\":\"Roger\",\"emailId\":\"lillian@bray.vn\"}]";
    Button showDataButton ;
    ListView listView ;
    List<ContactInfo> contactInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDataButton = (Button)findViewById(R.id.button);
        showDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // new FetchData(MainActivity.this,jsonURL).execute();
               // setJSONValues();
                setJsonUsingGson();

            }
        });
        listView = (ListView)findViewById(R.id.listview);
    }

    @Override
    public void setJsonResponse(String json) {
        this.json = json ;
    }


    void setJsonUsingGson(){
        Type listType = new TypeToken<ArrayList<ContactInfo>>(){}.getType();
        contactInfoList = new GsonBuilder().create().fromJson(json,listType);
        if(contactInfoList!=null)
            setValuesToList();

    }

    public void setJSONValues(){
        contactInfoList = new ArrayList<ContactInfo>();
        try{
            JSONArray jsonArray = new JSONArray(json);
            for(int i=0 ; i < jsonArray.length() ; i++){


                ContactInfo contactInfo = new ContactInfo();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String contactId = jsonObject.getString("contactId");

                String name  =jsonObject.getString("name");
                String landNo =jsonObject.getString("landNo");
                String mobileNo =jsonObject.getString("mobileNo");
                String emailId =jsonObject.getString("emailId");
                String remark =jsonObject.getString("remark");
                String city =jsonObject.getString("city");
                contactInfo.setContactId(contactId);
                contactInfo.setName(name);
                contactInfo.setLandno(landNo);
                contactInfo.setMobileNo(mobileNo);
                contactInfo.setEmailId(emailId);
                contactInfo.setRemark(remark);
                contactInfo.setCity(city);
                contactInfoList.add(contactInfo);
            }

    }catch (Exception e){
        e.printStackTrace();
    }finally {
            if(contactInfoList!=null)
                setValuesToList();
        }
    }

        void  setValuesToList(){
            ContactListAdapter contactListAdapter = new ContactListAdapter(MainActivity.this,R.layout.activity_main,contactInfoList);
            listView.setAdapter(contactListAdapter);

    }


}
