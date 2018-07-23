import org.jsoup.Jsoup

fun main(args: Array<String>) {
    val url = args[0]
    val doc = Jsoup.connect(url).get()
    val links = doc.select("link[rel*=icon]")
    for (link in links) {
        println(link.attr("rel") + ": " + link.attr("abs:href"))
    }
    val ogs = doc.select("meta[property=og:image]")
    for (og in ogs) {
        println(og.attr("property") + ": " + og.attr("content"))
    }
    val twitters = doc.select("meta[name=twitter:image]")
    for (twitter in twitters) {
        println(twitter.attr("name") + ": " + twitter.attr("content"))
    }
    val manifests = doc.select("link[href=/manifest.webmanifest]")
    for (manifest in manifests) {
        println("manifest" + ": " + manifest.attr("icons"))
    }
}