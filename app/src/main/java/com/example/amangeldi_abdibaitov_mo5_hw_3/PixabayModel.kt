package com.example.amangeldi_abdibaitov_mo5_hw_3

data class PixabayModel(
    val hits: List<ImageModel>
)

data class ImageModel(
    val largeImageURL: String
)
