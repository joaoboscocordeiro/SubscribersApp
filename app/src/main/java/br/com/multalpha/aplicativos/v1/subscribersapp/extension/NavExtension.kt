package br.com.multalpha.aplicativos.v1.subscribersapp.extension

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import br.com.multalpha.aplicativos.v1.subscribersapp.R

/**
 * Created by João Bosco on 30/09/2021.
 * e-mail - Support: ti.junior@gmail.com
 */

private val slideLeftOpitions = NavOptions.Builder()
    .setEnterAnim(R.anim.slide_in_right)
    .setExitAnim(R.anim.slide_out_left)
    .setPopEnterAnim(R.anim.slide_in_left)
    .setPopExitAnim(R.anim.slide_out_right)
    .build()

fun NavController.navigateWithAnimations(
    destinationId: Int,
    animation: NavOptions = slideLeftOpitions
) {
    this.navigate(destinationId, null, animation)
}

fun NavController.navigateWithAnimations(
    directions: NavDirections,
    animation: NavOptions = slideLeftOpitions
) {
    this.navigate(directions, animation)
}