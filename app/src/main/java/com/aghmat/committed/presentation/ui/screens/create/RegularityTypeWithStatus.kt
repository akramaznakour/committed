package com.aghmat.committed.presentation.ui.screens.create

import com.aghmat.committed.domain.enums.RegularityType

data class RegularityTypeWithStatus(
    val regularityType: RegularityType,
    var selected: Boolean,
)
