package com.aghmat.committed.domain.enums

import com.aghmat.committed.R

enum class RegularityType(val resource: Int) {
    EVERY_DAY(R.string.general_regularity_every_day),
    MONDAY(R.string.general_regularity_monday),
    TUESDAY(R.string.general_regularity_tuesday),
    WEDNESDAY(R.string.general_regularity_wednesday),
    THURSDAY(R.string.general_regularity_thursday),
    FRIDAY(R.string.general_regularity_friday),
    SATURDAY(R.string.general_regularity_saturday),
    SUNDAY(R.string.general_regularity_sunday)
}
