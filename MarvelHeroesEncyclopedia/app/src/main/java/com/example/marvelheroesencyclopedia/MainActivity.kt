package com.example.marvelheroesencyclopedia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelheroesencyclopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Marvel Heroes"

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val sys = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sys.left, sys.top, sys.right, sys.bottom)
            insets
        }

        val heroList = listOf(
            Hero(
                name            = "Iron Man",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/e/ee/Anthony_Stark_%28Earth-616%29_from_Iron_Man_Vol_7_6_002.jpg",
                realName        = "Anthony Edward \"Tony\" Stark",
                biography       = "Genius inventor and billionaire industrialist who built the powered suit of armor to save his own life and protect the world as Iron Man.",
                affiliation     = "Avengers; Stark Industries",
                firstAppearance = "Tales of Suspense #39 (1963)",
                series          = "Earth-616",
                height          = "6'1\" (185 cm)",
                powers          = "Powered armor grants flight, super-strength, energy repulsors, advanced AI and sensors"
            ),
            Hero(
                name            = "Captain America",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/4/4d/Captain_America_Vol_11_4_Stonehouse_Variant_Textless.jpg",
                realName        = "Steven Grant Rogers",
                biography       = "A frail young man transformed into the peak of human perfection by an experimental serum during WWII, dedicated to justice and freedom.",
                affiliation     = "Avengers; US Army",
                firstAppearance = "Captain America Comics #1 (1941)",
                series          = "Earth-616",
                height          = "6'2\" (188 cm)",
                powers          = "Enhanced strength, agility, endurance; vibranium shield expert"
            ),
            Hero(
                name            = "Thor",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/1/17/Immortal_Thor_Vol_1_15_Villalobos_Virgin_Variant.jpg",
                realName        = "Thor Odinson",
                biography       = "Norse god of thunder, wielder of the hammer Mjolnir. Defender of both Asgard and Earth from cosmic threats.",
                affiliation     = "Avengers; Asgardian Royal Family",
                firstAppearance = "Journey into Mystery #83 (1962)",
                series          = "Earth-616",
                height          = "6'6\" (198 cm)",
                powers          = "Superhuman strength/endurance, weather control, flight via Mjolnir"
            ),
            Hero(
                name            = "Black Widow",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/b/bb/Natalia_Romanova_%28Earth-616%29_from_Web_of_Black_Widow_Vol_1_5_Cover.jpg",
                realName        = "Natalia Alianovna Romanova",
                biography       = "Former Russian spy turned Avenger. Expert martial artist, tactician, and master of espionage.",
                affiliation     = "Avengers; S.H.I.E.L.D.",
                firstAppearance = "Tales of Suspense #52 (1964)",
                series          = "Earth-616",
                height          = "5'7\" (170 cm)",
                powers          = "Peak human conditioning, master spy, weapons expert"
            ),
            Hero(
                name            = "Hulk",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/b/b8/Incredible_Hulk_Vol_4_7_Textless.jpg",
                realName        = "Robert Bruce Banner",
                biography       = "After exposure to gamma radiation, Banner transforms into the Hulk when enraged, possessing limitless strength.",
                affiliation     = "Avengers; Pantheon",
                firstAppearance = "The Incredible Hulk #1 (1962)",
                series          = "Earth-616",
                height          = "8'0\"+ (244 cm+)",
                powers          = "Unlimited strength proportional to anger, regeneration, endurance"
            ),
            Hero(
                name            = "Spider-Man",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/7/71/Peter_Parker_%28Earth-616%29_from_Amazing_Spider-Man_Vol_5_15_Cover.jpg",
                realName        = "Peter Benjamin Parker",
                biography       = "Bitten by a radioactive spider, Parker gained arachnid abilities and fights crime while juggling everyday life.",
                affiliation     = "Avengers; Daily Bugle photographer",
                firstAppearance = "Amazing Fantasy #15 (1962)",
                series          = "Earth-616",
                height          = "5'10\" (178 cm)",
                powers          = "Wall-crawling, spider-sense, enhanced agility, web-shooters"
            ),
            Hero(
                name            = "Doctor Strange",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/5/53/Doctor_Strange_Vol_6_1_Textless.jpg",
                realName        = "Stephen Vincent Strange",
                biography       = "Former neurosurgeon who became Sorcerer Supreme after learning mystical arts to defend Earth from magical threats.",
                affiliation     = "Masters of the Mystic Arts",
                firstAppearance = "Strange Tales #110 (1963)",
                series          = "Earth-616",
                height          = "6'2\" (188 cm)",
                powers          = "Master sorcerer, teleportation, astral projection, time manipulation"
            ),
            Hero(
                name            = "Black Panther",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/7/7a/Wakanda_Vol_1_1_Klein_Variant_Textless.jpg",
                realName        = "T'Challa",
                biography       = "King of Wakanda, endowed with enhanced abilities by the Heart-Shaped Herb and clad in a vibranium suit.",
                affiliation     = "Avengers; Wakandan Royal Family",
                firstAppearance = "Fantastic Four #52 (1966)",
                series          = "Earth-616",
                height          = "6'0\" (183 cm)",
                powers          = "Enhanced senses, agility, strength; vibranium suit, genius strategist"
            ),
            Hero(
                name            = "Captain Marvel",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/4/4f/Carol_Danvers_%28Earth-616%29_from_Captain_Marvel_Vol_11_2_Stormbreakers_Variant_cover.jpg",
                realName        = "Carol Danvers",
                biography       = "Former USAF pilot transformed by alien Kree technology into one of the universe’s mightiest heroes.",
                affiliation     = "Avengers; Starforce",
                firstAppearance = "Marvel Super-Heroes #13 (1968)",
                series          = "Earth-616",
                height          = "5'11\" (180 cm)",
                powers          = "Energy absorption/projection, flight, super-strength"
            ),
            Hero(
                name            = "Scarlet Witch",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/8/85/Scarlet_Witch_Vol_3_1_Dauterman_Second_Printing_Variant.jpg",
                realName        = "Wanda Maximoff",
                biography       = "Mutant with reality-altering powers; member of the Avengers, her magic reshapes possibilities.",
                affiliation     = "Avengers; Brotherhood of Evil Mutants",
                firstAppearance = "X-Men #4 (1964)",
                series          = "Earth-616",
                height          = "5'5\" (165 cm)",
                powers          = "Chaos magic, probability hexes, reality manipulation"
            ),
            Hero(
                name            = "Vision",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/9/93/Vision_%28Earth-616%29_from_Avengers_Vol_9_2_001.jpg",
                realName        = "Synthezoid Vision",
                biography       = "Artificial being created by Ultron then reprogrammed to join the Avengers, constantly learning humanity.",
                affiliation     = "Avengers",
                firstAppearance = "Avengers #57 (1968)",
                series          = "Earth-616",
                height          = "6'3\" (191 cm)",
                powers          = "Density control, flight, energy beams, super-intelligence"
            ),
            Hero(
                name            = "Falcon",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/e/ed/Captain_America_Vol_11_6_Black_History_Month_Variant_Textless.jpg",
                realName        = "Samuel Thomas \"Sam\" Wilson",
                biography       = "Expert aerialist using a specialized wing pack; long-time ally and successor to Captain America.",
                affiliation     = "Avengers; U.S. Air Force",
                firstAppearance = "Captain America #117 (1969)",
                series          = "Earth-616",
                height          = "6'1\" (185 cm)",
                powers          = "Flight via flight suit, skilled tactician, hand-to-hand combat"
            ),
            Hero(
                name            = "Winter Soldier",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/a/a5/Thunderbolts_Vol_5_1_Textless.jpg",
                realName        = "James Buchanan \"Bucky\" Barnes",
                biography       = "Former sidekick of Captain America, brainwashed into an assassin, later reclaimed his identity.",
                affiliation     = "Avengers; US Intelligence",
                firstAppearance = "Captain America #1 (1941) as Bucky; Winter Soldier in Captain America #1 (2005)",
                series          = "Earth-616",
                height          = "6'0\" (183 cm)",
                powers          = "Peak human conditioning, cybernetic arm, expert marksman"
            ),
            Hero(
                name            = "Ant-Man",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/7/7c/Astonishing_Ant-Man_Vol_1_10_Mighty_Men_of_Marvel_Cancelled_Variant_Textless.jpg",
                realName        = "Scott Lang",
                biography       = "Reformed thief who adopted the Ant-Man mantle; uses Pym particles to shrink and communicate with ants.",
                affiliation     = "Avengers; Fantastic Four",
                firstAppearance = "Avengers #181 (1979) as Scott Lang; Hank Pym in Tales to Astonish #27 (1962)",
                series          = "Earth-616",
                height          = "6'1\" (185 cm) (when normal size)",
                powers          = "Size-shifting, insect communication, genius-level engineering"
            ),
            Hero(
                name            = "Wasp",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/f/f7/Wasp_Vol_1_1_Nie_Variant_Textless.jpg",
                realName        = "Hope Pym / Janet van Dyne",
                biography       = "Janet van Dyne co-founded the Avengers; Hope Pym later took up the Wasp identity and joined the team.",
                affiliation     = "Avengers",
                firstAppearance = "Tales to Astonish #44 (1963) as Janet; Hope in Ant-Man #1 (2003)",
                series          = "Earth-616",
                height          = "5'9\" (175 cm) (normal)",
                powers          = "Size-shifting, insect bio-blasts, flight"
            ),
            Hero(
                name            = "Star-Lord",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/5/53/Guardians_of_the_Galaxy_Vol_7_5_Vecchio_Variant_Textless.jpg",
                realName        = "Peter Quill",
                biography       = "Half-human, half-celestial outlaw who leads the Guardians of the Galaxy on cosmic adventures.",
                affiliation     = "Guardians of the Galaxy",
                firstAppearance = "Marvel Preview #4 (1976)",
                series          = "Earth-691 (original) / Earth-616 (main)",
                height          = "6'2\" (188 cm)",
                powers          = "Master tactician, cosmic energy manipulation, expert pilot/marksman"
            ),
            Hero(
                name            = "Gamora",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/d/dc/Guardians_of_the_Galaxy_Vol_7_7_Smith_Variant_Textless.jpg",
                realName        = "Gamora Zen Whoberi Ben Titan",
                biography       = "Adopted daughter of Thanos and last of her species, deadly assassin who turned against her father.",
                affiliation     = "Guardians of the Galaxy",
                firstAppearance = "Strange Tales #180 (1975)",
                series          = "Earth-616",
                height          = "6'0\" (183 cm)",
                powers          = "Enhanced strength, agility, expert martial artist, healing"
            ),
            Hero(
                name            = "Drax",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/c/c0/Infinity_Countdown_Vol_1_3_Drax_Holds_Infinity_Unknown_Comics_Exclusive_Virgin_Variant.jpg",
                realName        = "Arthur Douglas (reborn as Drax the Destroyer)",
                biography       = "Reincarnated spirit whose sole purpose is to destroy Thanos; immense physical power and cosmic awareness.",
                affiliation     = "Guardians of the Galaxy",
                firstAppearance = "Iron Man #55 (1973)",
                series          = "Earth-616",
                height          = "7'2\" (218 cm)",
                powers          = "Super strength, durability, regeneration, cosmic awareness"
            ),
            Hero(
                name            = "Rocket Raccoon",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/9/96/Rocket_Raccoon_%28Earth-616%29_from_Guardians_of_the_Galaxy_Vol_6_14_cover_001.jpg",
                realName        = "Rocket",
                biography       = "Genetically and cybernetically enhanced raccoon with keen tactical mind and love of weapons.",
                affiliation     = "Guardians of the Galaxy",
                firstAppearance = "Marvel Preview #7 (1976)",
                series          = "Earth-616",
                height          = "4' (122 cm)",
                powers          = "Genius-level engineer, master marksman, tactical strategist"
            ),
            Hero(
                name            = "Groot",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/6/60/Groot_%28Earth-616%29_from_Infinity_Countdown_Vol_1_1_001.jpg",
                realName        = "Groot",
                biography       = "Sentient tree-like creature whose vocabulary is nearly limited to \"I am Groot\", but with a noble heart.",
                affiliation     = "Guardians of the Galaxy",
                firstAppearance = "Tales to Astonish #13 (1960)",
                series          = "Earth-616",
                height          = "25+ ft (7.6 m)",

                powers          = "Regeneration, size manipulation, super strength, wood control"
            ),
            Hero(
                name            = "Nebula",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/4/45/Nebula_Vol_1_1_Textless.jpg",
                realName        = "Nebula",
                biography       = "Granddaughter of Thanos and wandering space pirate who seeks her own destiny apart from her family.",
                affiliation     = "Guardians of the Galaxy (former)",
                firstAppearance = "The Avengers #257 (1985)",
                series          = "Earth-616",
                height          = "5'6\" (168 cm)",
                powers          = "Cybernetic enhancements, expert combatant, psionic resistance"
            ),
            Hero(
                name            = "War Machine",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/a/a8/Invincible_Iron_Man_Vol_5_15_Textless.jpg",
                realName        = "James Rupert \"Rhodey\" Rhodes",
                biography       = "Long-time friend of Tony Stark who pilots heavily armed power armor as War Machine.",
                affiliation     = "Avengers; U.S. Air Force",
                firstAppearance = "Iron Man #118 (1979)",
                series          = "Earth-616",
                height          = "6'1\" (185 cm)",
                powers          = "Powered armor with heavy artillery, flight, shield defenses"
            ),
            Hero(
                name            = "Hawkeye",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/6/6c/Thunderbolts_Vol_4_1_Trading_Card_Variant_Textless.jpg",
                realName        = "Clinton Francis \"Clint\" Barton",
                biography       = "Master archer and marksman; formerly a villain before joining the Avengers as a valued hero.",
                affiliation     = "Avengers; West Coast Avengers",                firstAppearance = "Tales of Suspense #57 (1964)",
                series          = "Earth-616",
                height          = "6'3\" (191 cm)",
                powers          = "Master archery, expert tactician, hand-to-hand combat"
            ),
            Hero(
                name            = "Shang-Chi",
                thumbnailUrl    = "https://static.wikia.nocookie.net/marveldatabase/images/5/50/Shang-Chi_and_the_Ten_Rings_Vol_1_1_Textless.jpg",
                realName        = "Shang-Chi",
                biography       = "Raised to be the ultimate assassin, he rebelled to become a master martial artist fighting for justice.",
                affiliation     = "Heroes for Hire; Avengers",
                firstAppearance = "Special Marvel Edition #15 (1973)",
                series          = "Earth-616",
                height          = "5'10\" (178 cm)",
                powers          = "Peak human martial artist, chi control, weapons master"
            )
        )

        binding.heroesRecyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = HeroesAdapter(heroList) { hero ->
                val intent = Intent(this@MainActivity, HeroDetail::class.java).apply {
                    putExtra(HeroDetail.EXTRA_NAME,             hero.name)
                    putExtra(HeroDetail.EXTRA_IMAGE,            hero.thumbnailUrl)
                    putExtra(HeroDetail.EXTRA_SUBTITLE,         hero.realName)
                    putExtra(HeroDetail.EXTRA_DESC,             hero.biography)
                    putExtra(HeroDetail.EXTRA_ALTER_EGO,        hero.realName)
                    putExtra(HeroDetail.EXTRA_AFFILIATION,      hero.affiliation)
                    putExtra(HeroDetail.EXTRA_FIRST_APPEARANCE, hero.firstAppearance)
                    putExtra(HeroDetail.EXTRA_SERIES,           hero.series)
                    putExtra(HeroDetail.EXTRA_HEIGHT,           hero.height)
                    putExtra(HeroDetail.EXTRA_POWERS,           hero.powers)
                }
                this@MainActivity.startActivity(intent)
            }
        }
    }
}
