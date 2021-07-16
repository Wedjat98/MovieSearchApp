/*
 * このデータは、日本歴代興行成績上位の映画一覧から取得したものである。
 *     https://ja.wikipedia.org/wiki/日本歴代興行成績上位の映画一覧
 */


//映画データセットクラス
public class MovieData {

    public final static String[] data = {
            // "順位, タイトル, 公開年",
            "1, 劇場版「鬼滅の刃」無限列車編, 2020",
            "2, 千と千尋の神隠し, 2001",
            "3, タイタニック, 1997",
            "4, アナと雪の女王, 2014",
            "5, 君の名は。, 2016",
            "6, ハリー・ポッターと賢者の石, 2001",
            "7, もののけ姫, 1997",
            "8, ハウルの動く城, 2004",
            "9, 踊る大捜査線 THE MOVIE 2 レインボーブリッジを封鎖せよ!, 2003",
            "10, ハリー・ポッターと秘密の部屋, 2002",
            "11, アバター, 2009",
            "12, 崖の上のポニョ, 2008",
            "13, 天気の子, 2019",
            "14, ラスト サムライ, 2003",
            "15, E.T., 1982",
            "15, アルマゲドン, 1998",
            "15, ハリー・ポッターとアズカバンの囚人, 2004",
            "18, アナと雪の女王2, 2019",
            "19, ボヘミアン・ラプソディ, 2018",
            "20, ジュラシック・パーク, 1993",
            "21, スター・ウォーズ エピソード1 ファントム・メナス, 1999",
            "22, 美女と野獣, 2017",
            "23, アラジン, 2019",
            "24, 風立ちぬ, 2013",
            "25, アリス・イン・ワンダーランド, 2010",
            "26, スター・ウォーズ/フォースの覚醒, 2015",
            "27, 南極物語, 1983",
            "27, マトリックス・リローデッド, 2003",
            "27, ファインディング・ニモ, 2003",
            "27, ハリー・ポッターと炎のゴブレット, 2005",
            "31, パイレーツ・オブ・カリビアン ワールド・エンド, 2007",
            "32, トイ・ストーリー3, 2010",
            "33, インデペンデンス・デイ, 1996",
            "34, ロード・オブ・ザ・リング/王の帰還, 2004",
            "35, 踊る大捜査線 THE MOVIE, 1998",
            "36, トイ・ストーリー4, 2019",
            "37, パイレーツ・オブ・カリビアン デッドマンズ・チェスト, 2006",
            "38, 子猫物語, 1986",
            "39, シン・エヴァンゲリオン劇場版, 2021",
            "40, ミッション:インポッシブル2, 2000",
            "41, ハリー・ポッターと死の秘宝 Part2, 2011",
            "42, A.I., 2001",
            "43, ジュラシック・ワールド, 2015",
            "44, バック・トゥ・ザ・フューチャー PART2, 1989",
            "44, ロスト・ワールド/ジュラシック・パーク, 1997",
            "46, ハリー・ポッターと不死鳥の騎士団, 2007",
            "47, モンスターズ・インク, 2002",
            "47, 名探偵コナン 紺青の拳, 2019",
            "49, スター・ウォーズ エピソード2 クローンの攻撃, 2002",
            "50, 劇場版 コード・ブルー -ドクターヘリ緊急救命-, 2018",
            "51, 借りぐらしのアリエッティ, 2010",
            "52, 天と地と, 1990",
            "53, ベイマックス, 2014",
            "53, 名探偵コナン ゼロの執行人, 2018",
            "55, スター・ウォーズ エピソード3/シスの復讐, 2005",
            "56, ロード・オブ・ザ・リング, 2002",
            "57, ダ・ヴィンチ・コード, 2006",
            "58, ジョーズ, 1975",
            "59, モンスターズ・ユニバーシティ, 2013",
            "60, パイレーツ・オブ・カリビアン/生命の泉, 2011",
            "61, ターミネーター2, 1991",
            "62, 永遠の0, 2013",
            "63, マトリックス, 1999",
            "64, ROOKIES -卒業-, 2009",
            "65, 世界の中心で、愛をさけぶ, 2004",
            "66, STAND BY ME ドラえもん, 2014",
            "67, シン・ゴジラ, 2016",
            "68, 敦煌, 1988",
            "68, バック・トゥ・ザ・フューチャー PART3, 1990",
            "68, ターミネーター3, 2003",
            "71, HERO, 2007",
            "72, ディープ・インパクト, 1998",
            "73, ジュラシック・ワールド/炎の王国, 2018",
            "74, THE LAST MESSAGE 海猿, 2010",
            "75, ハリー・ポッターと謎のプリンス, 2009",
            "76, ロード・オブ・ザ・リング/二つの塔, 2003",
            "77, ゲド戦記, 2006",
            "78, 映画 妖怪ウォッチ 誕生の秘密だニャン!, 2014",
            "79, 花より男子F, 2008",
            "80, シックス・センス, 1999",
            "81, ズートピア, 2016",
            "82, スパイダーマン, 2002",
            "82, スター・ウォーズ/最後のジェダイ, 2017",
            "84, インディ・ジョーンズ/最後の聖戦, 1989",
            "85, BRAVE HEARTS 海猿, 2012",
            "86, スター・ウォーズ/スカイウォーカーの夜明け, 2019",
            "87, 踊る大捜査線 THE MOVIE3 ヤツらを解放せよ!, 2010",
            "87, ファンタスティック・ビーストと魔法使いの旅, 2016",
            "87, 怪盗グルーのミニオン大脱走, 2017",
            "90, ポケットモンスター ミュウツーの逆襲, 1998",
            "91, ダイ・ハード3, 1995",
            "92, スパイダーマン3, 2007",
            "93, LIMIT OF LOVE 海猿, 2006",
            "94, スピード, 1994",
            "95, ゴーストバスターズ, 1984",
            "96, オーシャンズ11, 2002",
            "97, 名探偵コナン から紅の恋歌, 2017",
            "98, パール・ハーバー, 2001",
            "99, ONE PIECE FILM Z, 2012",
            "100, ナルニア国物語/第1章:ライオンと魔女, 2006",
            "100, ハリー・ポッターと死の秘宝 PART1, 2010",
    };
}