package com.elfarsisy.githubapi.model

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Repository(
    val id: Int,
    val node_id: String,
    @Json(name = "name")
    val name: String,
    val full_name: String,
    val private: Boolean,
    @Json(name = "owner")
    val owner: User,
    val html_url: String,
    @Json(name = "description")
    val description: String,
    val fork: Boolean,
    val url: String,
    val forks_url: String,
    @Json(name = "keys_url")
    val keys_urls_url: String,
    val collaborators_url: String,
    val teams_url: String,
    val hooks_url: String,
    val issue_events_url: String,
    val events_url: String,
    val assignees_url: String,
    val branches_url: String,
    val tags_url: String,
    val blobs_url: String,
    val git_tags_url: String,
    val git_refs_url: String,
    val trees_url: String,
    val statuses_url: String,
    val languages_url: String,
    val stargazers_url: String,
    val contributors_url: String,
    val subscribers_url: String,
    val subscription_url: String,
    val commits_url: String,
    val git_commits_url: String,
    val comments_url: String,
    val issue_comment_url: String,
    val contents_url: String,
    val compare_url: String,
    val merges_url: String,
    val archive_url: String,
    val downloads_url: String,
    val issues_url: String,
    val pulls_url: String,
    val milestones_url: String,
    val notifications_url: String,
    val labels_url: String,
    val releases_url: String,
    val deployments_url: String,
    @Json(name = "created_at")
    val created_at: String,
    @Json(name = "updated_at")
    val updated_at: String,
    @Json(name = "pushed_at")
    val pushed_at: String,
    @Json(name = "git_url")
    val git_url: String,
    @Json(name = "ssh_url")
    val ssh_url: String,
    @Json(name = "clone_url")
    val clone_url: String,
    @Json(name = "svn_url")
    val svn_url: String,
    @Json(name = "homepage")
    val homepage: String?,
    @Json(name = "size")
    val size: Int,
    @Json(name = "stargazers_count")
    val stargazers_count: Int,
    @Json(name = "watchers_count")
    val watchers_count: Int,
    @Json(name = "language")
    val language: String?,
    @Json(name = "has_issues")
    val has_issues: Boolean,
    @Json(name = "has_projects")
    val has_projects: Boolean,
    @Json(name = "has_downloads")
    val has_downloads: Boolean,
    @Json(name = "has_wiki")
    val has_wiki: Boolean,
    @Json(name = "has_pages")
    val has_pages: Boolean,
    @Json(name = "forks_count")
    val forks_count: Int,
    @Json(name = "mirror_url")
    val mirror_url: String?,
    @Json(name = "archived")
    val archived: Boolean,
    @Json(name = "disabled")
    val disabled: Boolean,
    @Json(name = "open_issues_count")
    val open_issues_count: Int,
    @Json(name = "license")
    val license: License?,
    @Json(name = "forks")
    val forks: Int,
    @Json(name = "open_issues")
    val open_issues: Int,
    @Json(name = "watchers")
    val watchers: Int,
    @Json(name = "default_branch")
    val default_branch: String
) : Parcelable{



}

@Parcelize
data class License(

    val key: String,
    val name: String,
    val spdx_id: String,
    val url: String,
    val node_id: String
) : Parcelable