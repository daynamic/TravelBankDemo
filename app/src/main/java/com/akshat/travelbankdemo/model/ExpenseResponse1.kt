package com.akshat.travelbankdemo.model

import com.google.gson.annotations.SerializedName

data class Response (
	val response : List<ExpenseResponse1>? = null
)

data class ExpenseResponse1(
	val expenseResponse1: List<ExpenseResponse1Item>? = null
)

data class Thumbnails(

	@SerializedName("list")
	val list: String? = null,

	@SerializedName("full")
	val full: String? = null
)

data class ExpenseResponse1Item(

	@SerializedName("date")
	var date: String? = null,

	@SerializedName("fxRate")
	val fxRate: Any? = null,

	@SerializedName("distance")
	val distance: Int? = null,

	@SerializedName("mileageStops")
	val mileageStops: List<Any>? = null,

	@SerializedName("customFields")
	val customFields: List<Any>? = null,

	@SerializedName("fxAmount")
	val fxAmount: Any? = null,

	@SerializedName("description")
	val description: String? = null,

	@SerializedName("tripId")
	val tripId: Any? = null,

	@SerializedName("tripBudgetCategory")
	var tripBudgetCategory: String? = null,

	@SerializedName("source")
	val source: String? = null,

	@SerializedName("autoConverted")
	val autoConverted: Boolean? = null,

	@SerializedName("type")
	val type: String? = null,

	@SerializedName("mileageType")
	val mileageType: String? = null,

	@SerializedName("excluded")
	val excluded: Boolean? = null,

	@SerializedName("lineItems")
	val lineItems: List<Any>? = null,

	@SerializedName("syncedCardIsVirtual")
	val syncedCardIsVirtual: Boolean? = null,

	@SerializedName("reportingStatus")
	val reportingStatus: String? = null,

	@SerializedName("id")
	val id: String? = null,

	@SerializedName("logs")
	val logs: List<Any>? = null,

	@SerializedName("expenseCategoryId")
	val expenseCategoryId: String? = null,

	@SerializedName("amount")
	var amount: String? = null,

	@SerializedName("distanceRate")
	val distanceRate: Int? = null,

	@SerializedName("created")
	val created: String? = null,

	@SerializedName("expenseVenueTitle")
	var expenseVenueTitle: String? = null,

	@SerializedName("billable")
	val billable: Boolean? = null,

	@SerializedName("userId")
	val userId: String? = null,

	@SerializedName("corporateCard")
	val corporateCard: Boolean? = null,

	@SerializedName("customerName")
	val customerName: String? = null,

	@SerializedName("syncedCardId")
	val syncedCardId: Any? = null,

	@SerializedName("estimatedDistance")
	val estimatedDistance: Int? = null,

	@SerializedName("currencyCode")
	var currencyCode: String? = null,

	@SerializedName("updated")
	val updated: String? = null,

	@SerializedName("user")
	val user: User? = null,

	@SerializedName("expenseReportId")
	val expenseReportId: Any? = null,

	@SerializedName("status")
	val status: String? = null,

	@SerializedName("attachments")
	val attachments: List<AttachmentsItem1>? = null
)

data class AttachmentsItem1(

	@SerializedName("filename")
	val filename: String? = null,

	@SerializedName("original")
	val original: String? = null,

	@SerializedName("size")
	val size: Int? = null,

	@SerializedName("mime")
	val mime: String? = null,

	@SerializedName("_id")
	val id: String? = null,

	@SerializedName("thumbnails")
	val thumbnails: Thumbnails? = null,

	@SerializedName("userId")
	val userId: String? = null,

	@SerializedName("hash")
	val hash: String? = null
)

data class Meta(
	val any: Any? = null
)

data class User(

	@SerializedName("_logs")
	val logs: List<Any>? = null,

	@SerializedName("lastKnownIp")
	val lastKnownIp: String? = null,

	@SerializedName("created")
	val created: String? = null,

	@SerializedName("_meta")
	val meta: Meta? = null,

	@SerializedName("agencyId")
	val agencyId: String? = null,

	@SerializedName("type")
	val type: String? = null,

	@SerializedName("channels")
	val channels: List<String>? = null,

	@SerializedName("failedLoginAttemptsInARow")
	val failedLoginAttemptsInARow: List<Any>? = null,

	@SerializedName("reportingStatus")
	val reportingStatus: String? = null,

	@SerializedName("isInvited")
	val isInvited: Boolean? = null,

	@SerializedName("lockedOut")
	val lockedOut: Boolean? = null,

	@SerializedName("id")
	val id: String? = null,

	@SerializedName("updated")
	val updated: String? = null,

	@SerializedName("email")
	val email: String? = null,

	@SerializedName("status")
	val status: String? = null
)
