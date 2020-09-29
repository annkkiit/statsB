package com.ankit.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ankit.myapplication.POJO.Article;
import com.ankit.myapplication.POJO.GetResult;
import com.ankit.myapplication.POJO.Result;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private CardView buttonBack;
    private ImageView imageResult;
    private TextView result;
    private TextView seeDetails;
    private Result resultDetails = new Result();
    private RecyclerView listItem;
    private ArrayList<Article> articles;
    private LinearLayoutManager layoutManager;
    private ArticleAdapter articleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        initializeUI();

        new GetResult(this, result, imageResult,
                resultDetails,
                intent.getStringExtra("pregnancies"),
                intent.getStringExtra("glucose"),
                intent.getStringExtra("blood_pressure"),
                intent.getStringExtra("skin_thickness"),
                intent.getStringExtra("insulin"),
                intent.getStringExtra("bmi"),
                intent.getStringExtra("age")
        ).execute();

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        seeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetails = new Intent(ResultActivity.this, ResultDetail.class);
                intentDetails.putExtra("pregnancies", Integer.toString(resultDetails.getPregnancies()));
                intentDetails.putExtra("glucose", Integer.toString(resultDetails.getGlucose()));
                intentDetails.putExtra("blood_pressure", Integer.toString(resultDetails.getBloodPressure()));
                intentDetails.putExtra("skin_thickness", Integer.toString(resultDetails.getSkinThickess()));
                intentDetails.putExtra("insulin", Integer.toString(resultDetails.getInsulin()));
                intentDetails.putExtra("bmi", String.format("%.2f", resultDetails.getBmi()));
                intentDetails.putExtra("age", Integer.toString(resultDetails.getAge()));
                intentDetails.putExtra("result", resultDetails.getResult());
                startActivity(intentDetails);
            }
        });

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        listItem.setLayoutManager(layoutManager);
        articleAdapter = new ArticleAdapter(this, articles);
        listItem.setAdapter(articleAdapter);

        final SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(listItem);
    }

    private void initializeUI() {
        buttonBack = findViewById(R.id.buttonBack);
        imageResult = findViewById(R.id.img_result);
        result = findViewById(R.id.result);
        seeDetails = findViewById(R.id.see_details);
        listItem = findViewById(R.id.article_list_res);
        articles = new ArrayList<Article>() {{
            add(new Article("Diabetes - Symptoms, causes and treatment - Alodokter", "Diabetes is a long-lasting or chronic disease characterized by blood sugar (glucose) levels that are high or above normal values. Glucose that accumulates in the blood as a result of not being absorbed by body cells with good can cause various organ disorders. If diabetes is not controlled properly, complications can arise that endanger the sufferer's life. \n "+
                    "\n" +
                    "Glucose is the main source of energy for human cells. Sugar levels in the blood are controlled by the insulin hormone produced by the pancreas, which is an organ located behind the stomach. In diabetics, the pancreas is unable to produce insulin according to the body's needs. Without insulin, cells- body cells can not absorb and process glucose into energy. \n "+
                    "\n" +
                    "Types of Diabetes \n" +
                    "In general, diabetes is divided into two types, namely type 1 and type 2 diabetes. Type 1 diabetes occurs because the patient's immune system attacks and destroys the pancreatic cells that produce insulin. This results in an increase in blood glucose levels, resulting in damage to the pancreas. body organs. Type 1 diabetes is also known as autoimmune diabetes. The trigger for this autoimmune condition is still not known with certainty. The strongest suspicion is that it is caused by genetic factors from the patient who are also influenced by environmental factors. \n "+
                    "\n" +
                    "Type 2 diabetes is a type of diabetes that is more common. This type of diabetes is caused by the body's cells becoming less sensitive to insulin, so the insulin produced cannot be used properly (resistance of the body's cells to insulin). About 90-95%) percent of diabetics in the world suffer from this type of diabetes. \n "+
                    "\n" +
                    "Apart from these two types of diabetes, there is a special type of diabetes in pregnant women called gestational diabetes. Diabetes in pregnancy is caused by hormonal changes, and blood sugar will return to normal after pregnant women undergo labor. \n" +
                    "\n" +
                    "Gejala Diabetes\n" +
                    "Diabetes tipe 1 dapat berkembang dengan cepat dalam beberapa minggu, bahkan beberapa hari saja. Sedangkan pada diabetes tipe 2, banyak penderitanya yang tidak menyadari bahwa mereka telah menderita diabetes selama bertahun-tahun, karena gejalanya cenderung tidak spesifik. Beberapa gejala diabetes tipe 1 dan tipe 2 meliputi:\n" +
                    "\n" +
                    "Sering merasa haus.\n" +
                    "Sering buang air kecil, terutama di malam hari.\n" +
                    "Sering merasa sangat lapar.\n" +
                    "Turunnya berat badan tanpa sebab yang jelas.\n" +
                    "Berkurangnya massa otot.\n" +
                    "Terdapat keton dalam urine. Keton adalah produk sisa dari pemecahan otot dan lemak akibat tubuh tidak dapat menggunakan gula sebagai sumber energi.\n" +
                    "Lemas.\n" +
                    "Pandangan kabur.\n" +
                    "Luka yang sulit sembuh.\n" +
                    "Sering mengalami infeksi, misalnya pada gusi, kulit, vagina, atau saluran kemih.\n" +
                    "Beberapa gejala juga bisa menjadi tanda bahwa seseorang mengalami diabetes, antara lain:\n" +
                    "\n" +
                    "Mulut kering.\n" +
                    "Rasa terbakar, kaku, dan nyeri pada kaki.\n" +
                    "Gatal-gatal.\n" +
                    "Disfungsi ereksi atau impotensi.\n" +
                    "Mudah tersinggung.\n" +
                    "Mengalami hipoglikemia reaktif, yaitu hipoglikemia yang terjadi beberapa jam setelah makan akibat produksi insulin yang berlebihan.\n" +
                    "Munculnya bercak-bercak hitam di sekitar leher, ketiak, dan selangkangan, (akantosis nigrikans) sebagai tanda terjadinya resistensi insulin.\n" +
                    "Beberapa orang dapat mengalami kondisi prediabetes, yaitu kondisi ketika glukosa dalam darah di atas normal, namun tidak cukup tinggi untuk didiagnosis sebagai diabetes. Seseorang yang menderita prediabetes dapat menderita diabetes tipe 2 jika tidak ditangani dengan baik.\n" +
                    "\n" +
                    "Faktor Risiko Diabetes\n" +
                    "Seseorang akan lebih mudah mengalami diabetes tipe 1 jika memiliki faktor-faktor risiko, seperti:\n" +
                    "\n" +
                    "Memiliki keluarga dengan riwayat diabetes tipe 1.\n" +
                    "Menderita infeksi virus.\n" +
                    "Orang berkulit putih diduga lebih mudah mengalami diabetes tipe 1 dibandingkan ras lain.\n" +
                    "Bepergian ke daerah yang jauh dari khatulistiwa (ekuator).\n" +
                    "Diabetes tipe 1 banyak terjadi pada usia 4-7 tahun dan 10-14 tahun, walaupun diabetes tipe 1 dapat muncul pada usia berapapun.\n" +
                    "Sedangkan pada kasus diabetes tipe 2, seseorang akan lebih mudah mengalami kondisi ini jika memiliki faktor-faktor risiko, seperti:\n" +
                    "\n" +
                    "Kelebihan berat badan.\n" +
                    "Memiliki keluarga dengan riwayat diabetes tipe 2.\n" +
                    "Kurang aktif. Aktivitas fisik membantu mengontrol berat badan, membakar glukosa sebagai energi, dan membuat sel tubuh lebih sensitif terhadap insulin. Kurang aktif beraktivitas fisik menyebabkan seseorang lebih mudah terkena diabetes tipe 2.\n" +
                    "Usia. Risiko terjadinya diabetes tipe 2 akan meningkat seiring bertambahnya usia.\n" +
                    "Menderita tekanan darah tinggi (hipertensi).\n" +
                    "Memiliki kadar kolesterol dan trigliserida abnormal. Seseorang yang memiliki kadar kolesterol baik atau HDL (high-density lipoportein) yang rendah dan kadar trigliserida yang tinggi lebih berisiko mengalami diabetes tipe 2.\n" +
                    "Khusus pada wanita, ibu hamil yang menderita diabetes gestasional dapat lebih mudah mengalami diabetes tipe 2. Selain itu, wanita yang memiliki riwayat penyakit polycystic ovarian syndrome (PCOS) juga lebih mudah mengalami diabetes tipe 2.\n" +
                    "\n" +
                    "Diagnosis Diabetes\n" +
                    "Gejala diabetes biasanya berkembang secara bertahap, kecuali diabetes tipe 1 yang gejalanya dapat muncul secara tiba-tiba. Dikarenakan diabetes seringkali tidak terdiagnosis pada awal kemunculannya, maka orang-orang yang berisiko terkena penyakit ini dianjurkan menjalani pemeriksaan rutin. Di antaranya adalah:\n" +
                    "\n" +

                    "Ditinjau oleh: dr. Marianti", R.drawable.img_article1));
            add(new Article("What is diabetes mellitus?", "Diabetes mellitus is a disease that prevents your body from properly using the energy from the food you eat. Diabetes occurs in one of the following situations:\n" +
                    "\n" +
                    "The pancreas (an organ behind your stomach) produces little insulin or no insulin at all. Insulin is a naturally occurring hormone, produced by the beta cells of the pancreas, which helps the body use sugar for energy.\n" +
                    "-Or-\n" +
                    "\n" +
                    "The pancreas makes insulin, but the insulin made does not work as it should. This condition is called insulin resistance.\n" +
                    "To better understand diabetes, it helps to know more about how the body uses food for energy (a process called metabolism).\n" +
                    "\n" +
                    "Your body is made up of millions of cells. To make energy, the cells need food in a very simple form. When you eat or drink, much of your food is broken down into a simple sugar called glucose. Glucose provides the energy your body needs for daily activities.\n" +
                    "\n" +
                    "The blood vessels and blood are the highways that transport sugar from where it is either taken in (the stomach) or manufactured (in the liver) to the cells where it is used (muscles) or where it is stored (fat). Sugar cannot go into the cells by itself. The pancreas releases insulin into the blood, which serves as the helper, or the \"key,\" that lets sugar into the cells for use as energy.\n" +
                    "\n" +
                    "When sugar leaves the bloodstream and enters the cells, the blood sugar level is lowered. Without insulin, or the \"key,\" sugar cannot get into the body's cells for use as energy. This causes sugar to rise. Too much sugar in the blood is called \"hyperglycemia\" (high blood sugar).\n" +
                    "\n" + "What are the types of diabetes?\n" +
                    "There are two main types of diabetes: type 1 and type 2:\n" +
                    "\n" +
                    "Type 1 diabetes occurs because the insulin-producing cells of the pancreas (beta cells) are damaged. In type 1 diabetes, the pancreas makes little or no insulin, so sugar cannot get into the body's cells for use as energy. People with type 1 diabetes must use insulin injections to control their blood glucose. Type 1 is the most common form of diabetes in people who are under age 30, but it can occur at any age. Ten percent of people with diabetes are diagnosed with type 1.\n" +
                    "In type 2 diabetes (adult onset diabetes), the pancreas makes insulin, but it either doesn't produce enough, or the insulin does not work properly. Nine out of 10 people with diabetes have type 2. This type occurs most often in people who are over 40 years old but can occur even in childhood if there are risk factors present. Type 2 diabetes may sometimes be controlled with a combination of diet, weight management and exercise. However, treatment also may include oral glucose-lowering medications (taken by mouth) or insulin injections (shots).\n" +
                    "Other types of diabetes might result from pregnancy (gestational diabetes), surgery, use of certain medicines, various illnesses and other specific causes.\n" +
                    "\n" +
                    "What is gestational diabetes?\n" +
                    "Gestational diabetes occurs when there is a high blood glucose level during pregnancy. As pregnancy progresses, the developing baby has a greater need for glucose. Hormone changes during pregnancy also affect the action of insulin, which brings about high blood glucose levels.\n" +
                    "\n" +
                    "Pregnant women who have a greater risk of developing gestational diabetes include those who:\n" +
                    "\n" +
                    "Are over 35 years old\n" +
                    "Are overweight\n" +
                    "Have a family history of diabetes\n" +
                    "Have a history of polycystic ovarian syndrome\n" +
                    "Blood glucose levels usually return to normal after childbirth. However, women who have had gestational diabetes have an increased risk of developing type 2 diabetes later in life.\n" +
                    "\n" +
                    "What causes diabetes?\n" +
                    "The causes of diabetes are not known. The following risk factors may increase your chance of getting diabetes:\n" +
                    "\n" +
                    "Family history of diabetes\n" +
                    "African-American, Hispanic, Native American, or Asian-American race, Pacific Islander or ethnic background\n" +
                    "Being overweight\n" +
                    "Physical stress (such as surgery or illness)\n" +
                    "Use of certain medications, including steroids\n" +
                    "Injury to the pancreas (such as infection, tumor, surgery or accident)\n" +
                    "Autoimmune disease\n" +
                    "High blood pressure\n" +
                    "Abnormal blood cholesterol or triglyceride levels\n" +
                    "Age (risk increases with age)\n" +
                    "Smoking\n" +
                    "History of gestational diabetes\n" +
                    "It is important to note that sugar itself does not cause diabetes. Eating a lot of sugar can lead to tooth decay, but it does not cause diabetes.\n" +
                    "\n" +
                    "What are the symptoms of diabetes?\n" +
                    "The symptoms of diabetes include:\n" +
                    "\n" +
                    "Increased thirst\n" +
                    "Increased hunger (especially after eating)\n" +
                    "Dry mouth\n" +
                    "Frequent urination\n" +
                    "Unexplained weight loss (even though you are eating and feel hungry)\n" +
                    "Weak, tired feeling\n" +
                    "Blurred vision\n" +
                    "Numbness or tingling in the hands or feet\n" +
                    "Slow-healing sores or cuts\n" +
                    "Dry and itchy skin\n" +
                    "Frequent yeast infections or urinary tract infections\n" +
                    "What are the symptoms of low blood sugar?\n" +
                    "Most people have symptoms of low blood sugar (hypoglycemia) when their blood sugar is less than 70 mg/dl. (Your healthcare provider will tell you how to test your blood sugar level.)\n" +
                    "\n" +
                    "When your blood sugar is low, your body gives out signs that you need food. Different people have different symptoms. You will learn to know your symptoms.\n" +
                    "\n" +
                    "Common early symptoms of low blood sugar include the following:\n" +
                    "\n" +
                    "Feeling weak\n" +
                    "Feeling dizzy\n" +
                    "Feeling hungry\n" +
                    "Trembling and feeling shaky\n" +
                    "Sweating\n" +
                    "Pounding heart\n" +
                    "Pale skin\n" +
                    "Feeling frightened or anxious\n" +
                    "Late symptoms of low blood sugar include:\n" +
                    "\n" +
                    "Feeling confused\n" +
                    "Headache\n" +
                    "Feeling cranky\n" +
                    "Poor coordination\n" +
                    "Bad dreams or nightmares\n" +
                    "Being unable keep your mind on one subject\n" +
                    "Numbness in your mouth and tongue\n" +
                    "Passing out", R.drawable.img_article2));
            add(new Article("DIET TIPS TO PREVENT DIABETES", "To prevent or control diabetes you need to follow a healthy diet routine. Diet plan need not be too complicated. The simple strategy is consuming food that has low fat, moderate calories and high protein. Eating the right food is the first and foremost step for preventing diabetes.\n" +
                    "\n" + "Lose the extra pounds to reduce the risk of diabetes. Reducing even 10% of your weight can reduce the blood sugar level. Proper diet helps to avoid obesity and shed your pounds.\n" +
                    "\n" +
                    "You need not cut down the carbohydrates or fat completely. You can consume complex carbohydrates with high fibre content. Cut down unhealthy fats and include healthy fats. Saturated and Trans fats are unhealthy fats. Unsaturated fats are healthy fats that are good for health. Unsaturated fats are found in fish and plant sources. They are in liquid state at normal temperature.\n" +
                    "\n" +
                    "Diet for Preventing Diabetes\n" +
                    "Milk\n" +
                    "Drinking eight ounces of milk daily cuts the possibility of diabetes by 40%. Milk is rich in calcium, vitamin D and magnesium and it helps your body to use insulin properly. Drink skimmed or 1% milk. Avoid saturated fat as it is not beneficial.\n" +
                    "\n" +
                    "Coffee\n" +
                    "Daily down four cups of coffee and reduce the diabetes risk by 30%. Drink only filtered coffee for preventing diabetes. Unfiltered coffee increases your cholesterol.\n" +
                    "\n" +
                    "Nuts\n" +
                    "Eating nuts daily lowers your risk of diabetes by 20%. An ounce of any of the nuts such as walnuts, cashews or almonds would be beneficial. An ounce daily will not lead to weight gain.\n" +
                    "\n" +
                    "Cinnamon\n" +
                    "The aroma of this spice controls the fluctuations in blood sugar level, which is a factor for type 2 diabetes. You can sprinkle ½ tbsp of cinnamon daily on your cereals, yoghurt or anything of your choice.\n" +
                    "\n" +
                    "Eat Slow Release Carbohydrates\n" +
                    "When compared to proteins and fats, carbohydrates have a major impact on the blood sugar level. Reduce the intake of highly refined carbs such as rice, white bread, pasta, candy, soda and snacks. Complex carbohydrates with high fiber content are called as slow release carbohydrates. They help to maintain constant blood sugar level. They get digested slowly and prevent the production of insulin. It gives long lasting energy and makes you stay full for a long time.\n" +
                    "\n" +
                    "Glycemic Index(GI) notifies how fast your food gets converted into sugar. Glycemic load tells how the food you eat affects blood sugar level. Glycemic load is derived based on glycemic index and the carbohydrate amount in your food. High value of GI increases your blood sugar level fastly and low GI has good effects. Food can be broadly classified into three types\n" +
                    "\n" +
                    "Fire Foods\n" +
                    "These foods have more GI and less protein and fibre. It includes white foods like white rice, white bread, white pasta and potatoes. Processed foods, sweets and chips should also be avoided.\n" +
                    "\n" +
                    "Water Foods\n" +
                    "These are free foods and there is no restriction for eating these foods. It includes vegetables and fruits.  Dried fruits, canned fruits and fruit juices are not included in water foods.\n" +
                    "\n" +
                    "Coal Foods\n" +
                    "These foods are low in GI and high in protein and fibre. It includes whole grains, nuts, seeds, beans, lean meats and sea foods.", R.drawable.img_article3));
            add(new Article("Type 2 Diabetes Mellitus – Spiritual Meaning, Causes and Healing", "Type 2 diabetes accounts for 90% of all diabetes cases, and it commonly develops after the age of 40, which is why it used to be called “adult-onset diabetes.” It is characterized by high levels of sugar in the blood.\n" +
                    "\n" +
                    "Type 2 diabetes is much more frequent than type 1 diabetes and is really a totally different disease.\n" +
                    "\n" +
                    "It is one of the fastest growing public health problems in the increasingly obese western society.\n" +
                    "\n" +
                    "In the United States, over 100 million adults are now living with diabetes or prediabetes. An estimated 1.5 million new cases of diabetes are diagnosed in the US per year. In the UK, there are an estimated 12.3 million people at increased risk of type 2 diabetes.\n" +
                    "\n" +
                    "By the year 2020, more than 250 million people will be afflicted worldwide, resulting in a substantial financial burden, with more than $100 billion spent annually in the U.S. alone. Also, diabetes was the 7th leading cause of death in the United States in 2015. \n" +
                    "\n" +
                    "Diabetes is diagnosed by testing the blood for sugar levels. Blood is tested in the morning after you have fasted overnight.\n" +
                    "\n" +
                    "Type 2 Diabetes Symptoms:\n" +
                    "\n" + "frequent need to urinate;\n" +
                    "wounds that do not heal;\n" +
                    "being thirsty a lot of the time;\n" +
                    "increased susceptibility to infections, particularly yeast or fungal infections.\n" +
                    "Diabetes Mellitus Causes and Risk factors:\n" +
                    "When our food is digested, the glucose makes its way into our bloodstream.\n" + "\n" + "Our cells use glucose for growth and energy. But glucose cannot enter our cells without insulin being present (insulin makes it possible for our cells to take in the glucose).\n" + "\n" +
                    "The glucose level in the blood rises after a meal and triggers the pancreas to make the hormone insulin and release it into the bloodstream.\n" +
                    "\n" +
                    "But in individuals with this condition, the body either can’t produce or can’t respond to this hormone properly.\n" +
                    "\n" +
                    "Without it, glucose can’t get into the cells and so it stays in the bloodstream. Hence, the level of sugar in the blood remains higher than normal.\n" +
                    "\n" +
                    "The cause of insulin resistance\n" +
                    "What’s preventing insulin from letting glucose in? It’s fat. Intramyocellular lipids, or the fat inside our muscle cells.\n" +
                    "\n" +
                    "Fat in the bloodstream can build up inside the muscle cell and create toxic fatty breakdown products and free radicals that can block the insulin signaling process.\n" +
                    "\n" +
                    "When that happens, no matter how much hormone insulin we have in our blood, it won’t be able to open the glucose gates. That causes blood sugar levels to build up in the blood.\n" +
                    "\n" +
                    "Increased cellular fat is not just an innocent bystander, but rather a principal factor in promoting this metabolic disease.\n" +
                    "\n" +
                    "Abnormal high levels of cellular fat may activate a series of enzymes that in turn alters the molecular structure of key substrates involved in insulin action, affecting the transport and metabolism of glucose.\n" +
                    "\n" +
                    "Spiritual Causes of Type 2 Diabetes Mellitus\n" +
                    "The spiritual cause of the disease is emotional isolation and lack of sweetness in life. The bodies of diabetics cannot handle sugar because they cannot connect with life’s sweetness. So the best advice for diabetics is to “stop worrying and get happy”.\n" + "\n" +
                    "Prevention\n" +
                    "Nutrition\n" +
                    "The first step is to completely avoid animal-derived products. Needless to say, this eliminates all animal proteins and fats.\n" +
                    "\n" +
                    "The second step is to avoid added vegetable oils.\n" +
                    "\n" +
                    "For example, diabetes prevalence is relatively low among individuals following a plant-based diet, and clinical trials using such diet have shown improvements in glycemic control and cardiovascular health.\n" +
                    "\n" +
                    "Physical Exercise\n" +
                    "Exercise is one of the best and most effective ways to keep your blood glucose levels where they should be and lower them if they get too high.\n" +
                    "\n" +
                    "Because of modern living, it is essential to think about being physically active each day.\n" +
                    "\n" +
                    "Practicing more physical activity during your day is one of the most important things you can do to help manage your diabetes and improve your health.\n" +
                    "\n" +
                    "Tip – both resistance and aerobic exercise are important for people living with diabetes.\n" +
                    "\n" +
                    "SleepSleep Apnea Snoring - Emotional and Spiritual Meaning & Causes\n" +
                    "Sleep gives the body time to relax and repair and is now also understood to play a role in learning.\n" +
                    "\n" +
                    "Studies have shown that sleep deprivation and insulin resistance may be connected.\n" +
                    "\n" +
                    "Individuals who regularly lack sleep will feel more tired through the day and more likely to eat fattier foods.\n" +
                    "\n" +
                    "Quit Smoking\n" +
                    "Smokers are roughly 50% more likely to develop diabetes than nonsmokers, and heavy smokers have an even higher risk.\n" +
                    "\n" +
                    "Additionally, the risk of developing type 2 diabetes mellitus increases with the number of cigarettes smoked a day. \n" +
                    "\n" +
                    "Alcohol\n" +
                    "Alcohol can cause blood glucose levels to rise or fall, depending on how much you drink.\n" +
                    "\n" +
                    "Furthermore, alcohol impairs your liver’s ability to produce glucose and stimulates your appetite, which can cause you to overeat and may affect your blood sugar control.\n" + "\n" +
                    "Caffeine\n" +
                    "Caffeine affects every individual differently.\n" +
                    "\n" +
                    "If you have diabetes or you’re struggling to control your blood sugar levels, limiting the amount of caffeine in your diet may provide a benefit.\n" +
                    "\n" +
                    "Healing Affirmations\n" +
                    "I am completely comfortable with my life.\n" +
                    "\n" +
                    "My blood sugar is balanced.\n" +
                    "\n" +
                    "Every cell in my body is healthy and radiates health.\n" +
                    "\n" +
                    "I always make sure to eat the right foods.\n" +
                    "\n" +
                    "I breathe deeply and every breath energizes me.\n" +
                    "\n" +
                    "I am healed, whole, and healthy.", R.drawable.img_article4));
            add(new Article("Dry eyes with diabetes mellitus", "The metabolic disorder diabetes mellitus is one of the major public health problems of our time. Around eight million people in Germany suffer from diabetes. Diabetic retinopathy (changes in the retina due to diabetes) is a consequence of diabetes which affects the eye, often accompanied by dry eyes.\n" +
                    "\n" +
                    "Diabetes mellitus: when the blood sugar gets out of control\n" +
                    "Diabetes mellitus is a chronic metabolic disorder in which the body can no longer adequately regulate the blood sugar balance. Therefore, the blood sugar levels of diabetics fluctuate enormously. This has severe repercussions on the whole body, among other things on the eyes.\n" +
                    "\n" +
                    "The reason for the restricted regulation of blood sugar is the hormone insulin. Insulin is produced in the pancreas and ensures that the sugar, which goes into the blood from digesting food, is absorbed in the cells. The sugar is then stored in the cells as energy reserves and is released as required. Diabetics produce little or no insulin and in addition, the cells can often react a lot worse to insulin. They develop a resistance. The consequence: the sugar remains in the blood which, in the long run, leads to cell damage and changes in the blood vessels. People afflicted notice high blood sugar levels, for example through a constant urge to urinate and feeling very thirsty. The damage is irreparable and leads to serious consequences for organs and tissue.\n" +
                    "\n" +
                    "How strongly diabetes affects the body depends on how well blood sugar levels are managed and how long the disease persists.\n" +
                    " \n" +
                    "\n" +
                    "Diabetic retinopathy: severe changes to the retina due to diabetes\n" +
                    "Diabetic retinopathy is a disease of the retina and one of the most common causes of blindness in people between 20 and 65. In particular, the fine blood vessels, the capillaries, are affected by high blood sugar levels (microangiopathy). This has various effects in the eye: on the one hand, the capillaries become blocked so that the retina is no longer supplied with sufficient oxygen and nutrients. On the other, the walls of the blood vessels become more permeable wherein fluid and/or blood penetrates into the surrounding tissue. Oedemas (swellings) and/or bleeding occur in the retina. If untreated, the described changes to the retina can lead to the detachment of the retina and eventually to blindness. Dry eyes can also be associated with diabetes, which means a restriction in the quality of life for those affected.\n" +
                    " \n" +
                    "\n" +
                    "Diabetes often leads to dry eyes\n" +
                    "Due to restricted blood circulation in the structures of the eye, the nerves, which supply the eye, can be damaged. The nerves affected can be those which control the lacrimal glands. In this case, tear productsion is no longer adequately controlled, too little lacrimal fluid is produced and the eyes dry out. That is why diabetics’ eyes are more prone to infections like conjunctivitis or inflammation of the eyelid margin. These diseases also encourage the development of dry eyes.\n" +
                    " \n" +
                    "\n" +
                    "Regular check-ups by the eye doctor are essential\n" +
                    "With diabetes, the eyes should be examined at regular intervals. Good prevention means that changes in the eye can be treated in time and thus serious complications avoided. Moreover, it is important to balance the blood sugar levels as best as possible by taking insulin. In that way, damage to organs caused by diabetes can best be prevented. Also, discuss dry eye problems with your eye doctor because in the long run, these can greatly restrict your well-being and even lead to damage to the sensitive cornea. Your eye doctor will recommend a suitable treatment. You can also alleviate the symptoms yourself by using lubricating eye drops or a nurturing eye ointment. The substitute tears cover the irritated eye like a protective film and alleviate the itchy and burning feeling.", R.drawable.img_article5));
        }};
    }

}
