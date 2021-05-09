package org.bytesteam.mobile.scaffold

import android.content.Context
import android.content.Intent
import org.bytesteam.mobile.scaffold.base.BaseActivity

class DashboardActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_dashboard

    companion object {
        fun start(
            context: Context,
        ) {
            context.startActivity(Intent(context, DashboardActivity::class.java).apply {
            })
        }
    }
}