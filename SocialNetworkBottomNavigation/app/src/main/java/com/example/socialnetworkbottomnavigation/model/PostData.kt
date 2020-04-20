package com.example.socialnetworkbottomnavigation.model

import com.example.socialnetworkbottomnavigation.R

data class PostData(
    val postId: Int,
    val postLogo: Int,
    val postImage: Int,
    val postAuthor: String,
    val postLike: Int,
    val postDescription: String,
    val postComments: String,
    val postTime: String,
    var postLiked: Boolean? = false
)

object SetPostData {

    val firstPostData = PostData(
        1,
        R.drawable.ztb_kz,
        R.drawable.ztb_kz_image,
        "ztb_kz",
        213123,
        "Посол США в РК Уильям Мозер изучает казахский язык в режиме онлайн. " +
                "Видео одного из уроков опубликовано на официальной странице в Facebook" +
                " Посольства США в Казахстане.",
        "Посмотреть все комментарии (589)",
        "5 часов назад"
    )

    val secondPostData = PostData(
        2,
        R.drawable.nine_gag,
        R.drawable.nine_gag_image_2,
        "9gag",
        11231230,
        "I skipped right to week 5.",
        "Посмотреть все комментарии (2 433)",
        "6 часов назад"
    )
    val thirdPostData = PostData(
        3,
        R.drawable.kaznews,
        R.drawable.kaznews_image,
        "kaznews",
        113343,
        "Нариман Мукушев, занимающий должность вице-министра труда и соцзащиты," +
                " ответил на три вопроса о соцпособии в 42500 тенге, " +
                "которые чаще всего возникают у казахстанцев.,",
        "Посмотреть все комментарии (384)",
        "7 часов назад"
    )
    val fourthPostData = PostData(
        4,
        R.drawable.nine_gag,
        R.drawable.nine_gag_image,
        "9gag",
        213123,
        "My everyday struggle",
        "Посмотреть все комментарии (2 605)",
        "12 часов назад"
    )
    val fifthPostData = PostData(
        5,
        R.drawable.qazaqstories,
        R.drawable.qazaqstories_image,
        "qazaqstories",
        12345,
        "У всех так?",
        "Посмотреть все комментарии (109)",
        "день назад"
    )
    val sixthPostData = PostData(
        6,
        R.drawable.tut_slovar,
        R.drawable.tut_slovar_image,
        "tut_slovar",
        32345,
        "Узурпатор...",
        "Посмотреть все комментарии (73)",
        "день назад"
    )
    val seventhPostData = PostData(
        7,
        R.drawable.hyperpc,
        R.drawable.hyperpc_image,
        "hyperpc",
        1232145,
        "Кто-то уже успел увидеть еще вчера, а кто-то догадается \uD83D\uDE07\n" +
                "Хотите купить готовый компьютер или подбираете индивидуальную комплектацию?",
        "Посмотреть все комментарии (239)",
        "день назад"
    )
    val eighthPostData = PostData(
        8,
        R.drawable.banggood,
        R.drawable.banggood_image,
        "banggood",
        1232145,
        "Elephone’s newest gem is about to enter the market. " +
                "Let’s all come the beautifully designed E10 featuring " +
                "a long-lasting 4000mAh, NFC, " +
                "a 6.5” display, the latest version of Android 10.0" +
                " and a 48MP quad camera ID: 1661187",
        "Посмотреть все комментарии (339)",
        "день назад"
    )
    val ninthPostData = PostData(
        9,
        R.drawable.qazaqstories,
        R.drawable.qazaqstories_image_2,
        "qazaqstories",
        23554,
        "Жизағо \uD83D\uDE02",
        "Посмотреть все комментарии (49)",
        "день назад"
    )
    val tenthPostData = PostData(
        10,
        R.drawable.tut_slovar,
        R.drawable.tut_slovar_image_2,
        "tut_slovar",
        1232145,
        "#боке",
        "Посмотреть все ком ментарии (9)",
        "день назад"
    )
    val eleventhPostData = PostData(
        11,
        R.drawable.kaznews,
        R.drawable.kaznews_image_2,
        "kaznews",
        12234,
        "В США прошла волна протестов с требованием об" +
                " отмене карантина и возвращении к нормальной жизни.",
        "Посмотреть все комментарии (29)",
        "день назад"
    )
    val twelfthPostData = PostData(
        12,
        R.drawable.so_symbatty,
        R.drawable.so_symbatty_image,
        "so_symbatty",
        234,
        "in a room full of art, I would still stare at you",
        "Посмотреть все комментарии (6)",
        "день назад"
    )
    val thirteenthPostData = PostData(
        13,
        R.drawable.nine_gag,
        R.drawable.nine_gag_image_3,
        "9gag",
        2343252,
        "iUhm you done?",
        "Посмотреть все комментарии (952)",
        "2 дня назад"
    )
    val fourteenthPostData = PostData(
        14,
        R.drawable.kaznews,
        R.drawable.kaznews_image_3,
        "kaznews",
        12343,
        "Врач из США, который работает с пациентами, " +
                "у которых диагностирована коронавирусная инфекция, рассказал, " +
                "как поддерживает их и приободряет.",
        "Посмотреть все комментарии (43)",
        "2 дня назад"
    )
    val fifteenthPostData = PostData(
        15,
        R.drawable.zhumadilovva_image,
        R.drawable.zhumadilovva,
        "zhumadliovva",
        123,
        "«И так, читатель, привет! Сейчас у меня хорошее настроение. Я тут, " +
                "чтобы написать о том, что мне ровно через 10 дней исполнится 20.",
        "Посмотреть все комментарии (3)",
        "3 дня назад"
    )
    val sixteenthPostData = PostData(
        16,
        R.drawable.biggeekru,
        R.drawable.biggeekru_image,
        "biggeekru",
        1232,
        "Снова пошли слухи об AirPower, но у нас уже есть такая! \uD83D\uDE31",
        "Посмотреть все комментарии (232)",
        "3 дня назад"
    )
    val seventeenthPostData = PostData(
        17,
        R.drawable.banggood,
        R.drawable.banggood_image_2,
        "banggood",
        123,
        " We are offering a very tempting deal on this elegantly" +
                "designed urban backpack ID: 1542422",
        "Посмотреть все комментарии (532)",
        "3 дня назад"
    )
    val eighteenthPostData = PostData(
        18,
        R.drawable.kaznews,
        R.drawable.kaznews_image_4,
        "kaznews",
        12322,
        " На фасаде одного из жилых комплексов уже в скором времени появится мурал," +
                " нарисованный в честь врачей, которые борются с распространением" +
                " коронавируса на самой, что называется, передовой.",
        "Посмотреть все комментарии (152)",
        "4 дня назад"
    )
    val nineteenthPostData = PostData(
        19,
        R.drawable.corsair_russia_image,
        R.drawable.corsair_russia,
        "corsair_russia",
        1902,
        "Снова пошли слухи об AirPower, но у нас уже есть такая! \uD83D\uDE31",
        "Посмотреть все комментарии (132)",
        "4 дня назад"
    )
    val twentiethPostData = PostData(
        20,
        R.drawable.qazaqstories,
        R.drawable.qazaqstories_image_3,
        "qazaqstories",
        1234,
        "Қарайғандар барма? \uD83D\uDE02",
        "Посмотреть все комментарии (92)",
        "4 дня назад"
    )
}