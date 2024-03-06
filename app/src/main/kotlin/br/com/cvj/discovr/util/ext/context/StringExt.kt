package br.com.cvj.discovr.util.ext.context

fun String.removeAfterComma(): String {
    return this.replaceAfter(",", "").replace(",", "")
}
